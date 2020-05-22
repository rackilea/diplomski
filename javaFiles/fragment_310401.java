<appender name="console" class="org.apache.log4j.ConsoleAppender">
    <layout class="it.openutils.log4j.FilteredPatternLayout">
        <param name="ConversionPattern" value="%-5p  %c %F(%M:%L) %d{dd.MM.yyyy HH:mm:ss}  %m%n" />
        <param name="Filter" value="org.apache.catalina" />
        <param name="Filter" value="org.apache.tomcat" />
        <param name="Filter" value="org.apache.coyote" />
        <param name="Filter" value="org.myapp.web.filters" />
        <param name="Filter" value="com.opensymphony.module.sitemesh.filter" />
        <param name="Filter" value="sun.reflect" />
        <param name="Filter" value="javax.servlet.http" />
    </layout>
</appender>