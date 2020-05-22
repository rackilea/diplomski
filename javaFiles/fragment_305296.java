if( pathToFile == null ) throw new Exception("You must supply a pathToFile parameter");

Element records = new File( pathToFile ).withReader( "utf-8" ) { r ->
  DocumentBuilderFactory.newInstance().newDocumentBuilder().with { b ->
    b.parse( new InputSource( r ) ).documentElement
  }
}