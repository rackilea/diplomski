val handlers = Map( "msgid1"->Handler1, "msgid2->Handler2 )

onReceive( msg ) {
    val h = handlers(msg.id)

    h.doWork( msg )
}