if (response.getCode() == 200){
   String result = new String(response.getContent(), "UTF-8");


   if (result != null){
       Gson gson = new Gson();
       YourObject obj = gson.fromJson(result,YourObject.class);
   }
}