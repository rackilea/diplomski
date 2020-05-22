<appender name="consoleAppender" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern"
               value="\u001b[0;%X{randColor}m ....... \u001b[m" />
    </layout>
</appender>