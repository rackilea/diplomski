@Override
public void configure() throws Exception {
    String dailyDataUri = "{{SOCKET.daily.file}}" + "&fileName=SocketData-${date:now:yyyyMMdd}.txt";
    from(socketLocation).routeId("thisRoute")
    .transform(body().append("\n"))
    .wireTap(dailyDataUri)
    .to(destination)
;