new Thread(conn).start()
while (true) {
    //note the lack of sending messages in here
    val rxMsg = conn.getMsg(server)
    val parser = new JsonParser(rxMsg)
    val formattedMsg = parser.formatMsg(parser.toJson()) 
    println(formattedMsg)
    msgAcc = msgAcc + formattedMsg + "\n" 
}