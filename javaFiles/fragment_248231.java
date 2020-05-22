while ((line = br.readLine()) != null) {

 String[] a = line.split(splitBy);
 for(String s: a){
    if(s!=null && !s.trim().isEmpty()){
       System.out.println("Error");
    }
 }

 System.out.println("Checked By " + a[7] + ",");

}