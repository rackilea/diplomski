val (host, port, dbName, docsCollName) = 
  try {
    val prop = new Properties()
    prop.load(new FileInputStream("config.properties"))

    (
      prop.getProperty("mongo.host"),
      new Integer(prop.getProperty("mongo.port")),
      prop.getProperty("mongo.db"),
      prop.getProperty("mongo.coll.docs")
    ) 
    } catch { case e: Exception => 
      e.printStackTrace()
      sys.exit(1)
    }