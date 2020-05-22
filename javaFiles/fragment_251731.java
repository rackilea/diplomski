public static void main(String[] args){

      HashMap<String,String> M1=new HashMap<String,String>();
      HashMap<String,String> M2=new HashMap<String,String>();
      HashMap<String,String> M3=new HashMap<String,String>();
      M1.put("222", "Greg");
      M2.put("222","70.5");
      M3.put("222", "72.5");

      for(String key:M1.keySet()) {
        if(M2.containsKey(key)){
            double average = (Double.parseDouble(M2.get(key))+Double.parseDouble(M3.get(key)))/2d;
            System.out.println(key+" "+M1.get(key)+" "+ "course1:"+ " " + M2.get(key)+ " " +  "course2:"+ " " + M3.get(key)+" average:"+average);
        }
    }

}