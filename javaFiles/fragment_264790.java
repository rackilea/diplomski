user> (org.apache.giraph.GiraphRunner.) ; create a new GiraphRunner
CompilerException java.lang.NoClassDefFoundError: org/apache/hadoop/util/Tool, compiling:(/tmp/form-init5282725623346658314.clj:1:50) 
user> (still/distill '[[org.apache.hadoop/hadoop-core "0.20.2"]])
WARN: commons-logging version 1.0.3 requested, but 1.1.1 already on classpath.
WARN: commons-codec version 1.3 requested, but 1.6 already on classpath.
Loaded dependencies:
[[ant "1.6.5"]
 [commons-cli "1.2"]
 [commons-el "1.0"]
 [commons-httpclient "3.0.1"]
 [commons-net "1.4.1"]
 [hsqldb "1.8.0.10"]
 [junit "4.5"]
 [oro "2.0.8"]
 [xmlenc "0.52"]
 [net.java.dev.jets3t/jets3t "0.7.1"]
 [net.sf.kosmosfs/kfs "0.3"]
 [org.apache.hadoop/hadoop-core "0.20.2"]
 [org.eclipse.jdt/core "3.1.1"]
 [org.mortbay.jetty/jetty "6.1.14"]
 [org.mortbay.jetty/jetty-util "6.1.14"]
 [org.mortbay.jetty/jsp-2.1 "6.1.14"]
 [org.mortbay.jetty/jsp-api-2.1 "6.1.14"]
 [org.mortbay.jetty/servlet-api-2.5 "6.1.14"]
 [tomcat/jasper-compiler "5.5.12"]
 [tomcat/jasper-runtime "5.5.12"]]
Dependencies not loaded due to conflict with previous jars :
[[commons-codec "1.3"] [commons-logging "1.0.3"]]
nil
user> (org.apache.giraph.GiraphRunner.) ; create a new GiraphRunner
#<GiraphRunner org.apache.giraph.GiraphRunner@2dbfe923>
user> (bean *1)
{:conf nil, :class org.apache.giraph.GiraphRunner}