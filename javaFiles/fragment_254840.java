from("netty:tcp://localhost:5150?sync=false&keepAlive=true").to("seda:break");


from("seda:break").threads(5)
.routeId("tcp.input")
.transform()
.simple("insert into tamponems (AVIS) values (\"${in.body}\");")
.to("jdbc:mydb");