<appender name="fileAppender1" class="ch.qos.logback.core.FileAppender">
        <if condition='property("type").contains("DEV")'>
            <then>
                <file>${USER_HOME}/${log.name}.log</file>
            </then>
            <else>
                <file>${USER_HOME2}/${log.name}.log</file>
            </else>
        </if>
        <append>true</append>
        <encoder>
           <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{35} -
            %msg%n</pattern>
        </encoder>
    </appender>