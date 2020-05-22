String sentence = "I tried to speak @ty Spanish @ty-1, and my@ty-2 friend tried to@ty-3 speak English @ty.";
  String[] arr=sentence.replaceAll(",","").split(" ");
  List<String> list=new ArrayList<>();
  for(String i:arr){
     if(i.contains("@")){
         list.add(i.substring(i.indexOf("@"),i.length()));
      }
    }
  System.out.println(list);