Iterator<String[]> iter = theRecord.iterator();
while(iter.hasNext()){
   String[] temp = iter.next(); 
   for(int i=0;i<temp.length;i++){
       //manipulate temp[i]
   }
}