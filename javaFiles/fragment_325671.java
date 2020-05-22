<ftp:connector name="archivingFtpConnector" doc:name="FTP"
        pollingFrequency="${frequency}"
        validateConnections="true"
        connectionFactoryClass="my.comp.SafeFtpConnectionFactory">
    <reconnect frequency="${reconnection.frequency}" count="${reconnection.attempt}"/>
</ftp:connector>