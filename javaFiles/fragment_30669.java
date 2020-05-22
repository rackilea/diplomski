Class datatype;
switch(datatypeInt){
  case 2:
    datatype = Simple3DData.class;
    break;
  case 1:
  default:
    datatype = Simple2DData.class;
}
Scan = new Scan();