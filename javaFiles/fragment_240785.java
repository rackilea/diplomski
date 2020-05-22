<path id="classpath.web">
    <pathelement path="${third_party}/java/jsdk2.1/servlet.jar"/>
    <pathelement path="${third_party}/java/jaf/activation.jar"/>
    <pathelement path="${third_party}/java/javamail/mail.jar"/>
    <pathelement path="${third_party}/java/jetty/lib/jetty.jar"/>
    <pathelement path="${third_party}/java/jetty/lib/jetty-util.jar"/>
  </path>
  <path id="classpath.compile">
    <path refid="classpath.web"/>
    <pathelement path="${third_party}/java/jakarta_commons/commons-cli.jar"/>
    <pathelement path="${third_party}/java/json_simple/json_simple.jar"/>
    <pathelement path="${third_party}/java/rhino/js.jar"/>
    <pathelement path="${third_party}/java/xerces/xercesImpl.jar"/>
    <pathelement path="${jars}/htmlparser.jar"/>
  </path>
  <path id="classpath.run">
    <pathelement path="${lib}"/>
    <path refid="classpath.compile"/>
  </path>