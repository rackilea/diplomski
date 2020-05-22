<Appenders>
    <SMTP name="Mailer" suppressExceptions="false"
          subject="${subject}" to="${receipients}" from="${from}"
          smtpHost="${smtpHost}" smtpPort="${smtpPort}"
          smtpProtocol="${smtpProtocol}" smtpUsername="${smtpUser}"
          smtpPassword="${smtpPassword}" smtpDebug="false" bufferSize="20">

        <ThresholdFilter level="debug" onMatch="NEUTRAL" onMismatch="DENY" /> 
        <PatternLayout>
            <pattern>%d{dd-MM-yyyy HH:mm:ss,SSS} %5p %m%n</pattern>
        </PatternLayout>
    </SMTP>

    <Async name="AsyncMailer">
        <AppenderRef ref="Mailer"/>
    </Async>
</Appenders>
<Loggers>
    <Root level="info">
        <AppenderRef ref="AsyncMailer" />
    </Root>
</Loggers>