private final int PARSE_XML = 0
private final int PARSE_JSON = 1

void parseXml(){
  new FichaProducto(codigoBuscar, currentUser, ip, port, PARSE_XML)
}

@Override
onTaskCompleted(int id){
    switch (id){
      case PARSE_XML:
       break;
      case PARSE_JSON:
       break;
    }
}