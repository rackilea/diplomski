//This is your new run method in your Runnable
override def run(): Unit = {
    while(true) {
        tx = StdIn.readLine()
        conn.sendMsg(server, user, tx) //Note you'll need to pass those references in somehow
    }
}`