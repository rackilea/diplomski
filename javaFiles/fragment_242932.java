public static String queryFitter(String query, ArrayList<String> args){

   for(int i=0;i<args.size();i++){
      query = query.replaceFirst("\\?",args.get(i));
   } 

   return query;
}