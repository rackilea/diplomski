> jar tf superapp-1.0-SNAPSHOT.war
META-INF/
META-INF/MANIFEST.MF
WEB-INF/
WEB-INF/classes/
WEB-INF/content/
WEB-INF/classes/hello.txt
WEB-INF/content/test.jsp
WEB-INF/web.xml
META-INF/maven/sub.optimal.example/superapp/pom.xml
META-INF/maven/sub.optimal.example/superapp/pom.properties

# copy the file into a temp directory and extract it
# jar xf superapp-1.0-SNAPSHOT.war

>cat WEB-INF/classes/hello.txt
Hello $ world txt
Hello # world txt
Hello @ @{test.version} txt

>cat WEB-INF/content/test.jsp
Hello $ world jsp
Hello # world jsp
Hello @ @{test.version} jsp