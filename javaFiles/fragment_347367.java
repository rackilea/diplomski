onMessage(ActiveMQTextMessage message)
try {
    do some stuff in the database
    jdbc.commit(); (unless auto-commit is enabled on the JDBC)
    message.acknowledge();
}
catch (Exception e) {
}