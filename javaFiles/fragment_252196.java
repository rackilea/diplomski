$ cd /path/to/my-jetty-base
$ java -jar /path/to/jetty-home/start.jar --list-config

Java Environment:
-----------------
 java.home = /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre (null)
 java.vm.vendor = Oracle Corporation (null)
 java.vm.version = 25.202-b08 (null)
 java.vm.name = Java HotSpot(TM) 64-Bit Server VM (null)
 java.vm.info = mixed mode (null)
 java.runtime.name = Java(TM) SE Runtime Environment (null)
 java.runtime.version = 1.8.0_202-b08 (null)
 java.io.tmpdir = /var/folders/w5/mmnzpk0n369dntp4nszlc8h40000gn/T/ (null)
 user.dir = /path/to/my-jetty-base (null)
 user.language = en (null)
 user.country = US (null)

Jetty Environment:
-----------------
 jetty.version = 9.4.15.v20190215
 jetty.tag.version = master
 jetty.home = /path/to/jetty-home
 jetty.base = /path/to/my-jetty-base

...(snip lots of output)...

Jetty Active XMLs:
------------------
 ${jetty.home}/etc/jetty-threadpool.xml
 ${jetty.home}/etc/jetty.xml
 ${jetty.home}/etc/jetty-webapp.xml
 ${jetty.home}/etc/jetty-plus.xml
 ${jetty.home}/etc/jetty-annotations.xml
 ${jetty.home}/etc/jetty-deploy.xml
 ${jetty.home}/etc/jetty-http.xml
 ${jetty.home}/etc/jetty-ssl.xml      <-- THIS LINE
 ${jetty.home}/etc/jetty-ssl-context.xml
 ${jetty.home}/etc/jetty-https.xml
 ${jetty.home}/etc/jetty-jaas.xml
 ${jetty.home}/etc/jetty-rewrite.xml
 ${jetty.base}/etc/demo-rewrite-rules.xml
 ${jetty.base}/etc/test-realm.xml