double sum = 0.0; //if you use version earlier than java-8
//double sum = IntStream.of(keyList).sum(); //if you are using java-8 
for(int i = 0 ; i < keyList.size() ; i++){
  sum += keyList.get(i);    
}
for(int i = 0 ; i < keyList.size() ; i++){
  System.out.println((keyList.get(i)/sum )*100 + "%");
}