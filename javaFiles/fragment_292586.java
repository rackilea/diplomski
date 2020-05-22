set CLASSPATH=C:\ProjectWorkSpace\myProject\build\myProject\WEB-INF\lib\selenium-server-standalone-2.32.0.jar; ^
C:\ProjectWorkSpace\myProject\build\myProject\WEB-INF\lib\jsoup-1.7.2.jar; ^
C:\ProjectWorkSpace\myProject\build\myProject\WEB-INF\lib\xstream-1.1.3.jar; ^
.... ^
.... ^
C:\ProjectWorkSpace\myProject\web\WEB-INF\classes;

java -Xmx1024m -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=128m com.myProject.batch.PropertyRatesUpdaterBatchJob