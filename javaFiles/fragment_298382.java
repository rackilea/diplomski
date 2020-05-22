public static void main(String args[]) throws IOException{
     List<String> list = new ArrayList<String>();
     List<String> temp = new ArrayList<String>();
     InputStreamReader r=new InputStreamReader(System.in);  
     BufferedReader br=new BufferedReader(r);  


     for (int i=0;i<15;i++)
     {
         System.out.println("Enter value");
         String x=br.readLine();
         list.add(x);
     }

LinkedHashMap<String, Integer> lhm=new LinkedHashMap<String, Integer>();

for(String str1:list){
    int flag=0;
    for(Entry<String, Integer> entry:lhm.entrySet()){   

        if(entry.getKey().equals(str1)){
            flag=1;
            break;
        }}
        if(flag==0){
            lhm.put(str1, 1);
        }


}

int maxCount = 1;
int currCount = 1;
for (int i=1;i<list.size();++i) {
  if (list.get(i).equals(list.get(i-1))) {
    ++currCount;
    if(list.size()==i+1){
        maxCount = Math.max(lhm.get(list.get(i)), currCount); 
      lhm.put(list.get(i), maxCount);
    }
  } else {
      maxCount = Math.max(lhm.get(list.get(i-1)), currCount); 
      lhm.put(list.get(i-1), maxCount);
    currCount = 1;
  }

}


for(Entry<String, Integer> entry:lhm.entrySet()){
    System.out.println("Maximum Sequential occurrence of element- "+entry.getKey()+" is- "+entry.getValue());//display result
}


}