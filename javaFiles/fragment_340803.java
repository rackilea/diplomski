private static URL createURL(String path) {
     try {
         return ....;
     } catch(MalformedURLException e){
         // handle somehow
         throw new RuntimeException(e);
     }
}