public OutputObject process(InputObject item) throws Exception {

   ...
   Map myMap = ....
   OutputObject out = new OutputObject();
   out.setMyMap(myMap);
   return out;
}