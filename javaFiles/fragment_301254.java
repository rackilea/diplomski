private static boolean isJson(FileReader f) {
try{
     JsonElement json = new JsonParser().parse(f);
   }
catch (Exception e) {
     return false;
   }
return true;
}