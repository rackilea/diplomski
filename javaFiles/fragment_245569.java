for(Map.Entry<Integer,Girl> entry: girls.entrySet()) {

   Integer id = entry.getKey();
   Girl girl = entry.getValue();
   System.out.println(girl.name); //here you can do anything to the Girl, what morality permits...

}