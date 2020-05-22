if(args.length != 1){
     System.out.println("Please enter a txt file");
}
else{
    String s;
    try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
      while ( (s = br.readLine()) != null) {
         String[] words = s.split("[^a-zA-Z0-9]+");
         for(int i = 0; i < words.length; i++){
           //code
         }
      }
      br.close();
    }catch (FileNotFoundException ex){
         System.out.println(ex);
    }
    catch (IOException ex){
        System.out.println(ex);
    }
}