<if condition='property("type").contains("DEV")'>
    <then>
        <appender name="fileAppender1" class="ch.qos.logback.core.FileAppender">
        <file>${USER_HOME}/${log.name}.log</file>
        <append>true</append>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{35} -
                %msg%n</pattern>
            </encoder>
        </appender>
    </then>
    <else>
        <appender name="fileAppender1" class="ch.qos.logback.core.FileAppender">
        <file>${USER_HOME2}/${log.name}.log</file>
        <append>true</append>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{35} -
                %msg%n</pattern>
            </encoder>
        </appender>
    </else>
    </if>

    <root level="DEBUG">
        <appender-ref ref="fileAppender1" />
    </root>