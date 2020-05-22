%module test

%{
#include "test.hh"
#include <sstream>
#include <cassert>
static const char *defaultLogname="$module"; // Use if we're not in a class
%}

// Exception handling for all wrapped calls
%exception {
  // Hook output into this:
  std::stringstream out;

  // Save old states
  auto old_outbuf = std::cout.rdbuf();
  auto old_errbuf = std::cerr.rdbuf();
  // Do actual buffer switch
  std::cout.rdbuf(out.rdbuf());
  std::cerr.rdbuf(out.rdbuf());
  try {
    $action
  }
  catch (...) {
    // TODO: use RAII instead of poor finally substitute?
    std::cout.rdbuf(old_outbuf);
    std::cerr.rdbuf(old_errbuf);
    throw;
  }
  // Restore state
  std::cout.rdbuf(old_outbuf);
  std::cerr.rdbuf(old_errbuf);

  // JNI calls to find mid and instance for Logger.error(String) for the right name
  static const std::string class_name = "$parentclassname";
  // prepare static call to org.apache.logging.log4j.LogManager.getLogger(String)
  // start with class lookup:
  jclass logmanagercls = JCALL1(FindClass, jenv, "org/apache/logging/log4j/LogManager");
  assert(logmanagercls);
  // find method ID for right overload of getLogger
  jmethodID getloggermid = JCALL3(GetStaticMethodID, jenv, logmanagercls, "getLogger", "(Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;");
  assert(getloggermid);

  // Prep name strign to pass into getLogger
  jstring logname = JCALL1(NewStringUTF, jenv, (class_name.size() ? class_name.c_str(): defaultLogname));

  // Actually get the Logger instance for us to use
  jobject logger = JCALL3(CallStaticObjectMethod, jenv, logmanagercls, getloggermid, logname);
  assert(logger);
  // Lookup .error() method ID on logger, we need the jclass to start
  jclass loggercls = JCALL1(GetObjectClass, jenv, logger);
  assert(loggercls);
  // and the method ID of the right overload
  jmethodID errormid = JCALL3(GetMethodID, jenv, loggercls, "error", "(Ljava/lang/String;)V");
  assert(errormid);

  // Loop over all the lines we got from C++:
  std::string msg;
  while(std::getline(out, msg)) {
    // Pass string into Java logger
    jstring jmsg = JCALL1(NewStringUTF, jenv, msg.c_str());
    JCALL3(CallVoidMethod, jenv, logger, errormid, jmsg);
  }
}

// And of course actually wrap our test header    
%include "test.hh"