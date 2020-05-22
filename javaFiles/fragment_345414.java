ArrayList<String> nameGroups=new ArrayList<>();

for (Pending pn : pending) {
   if (a.length() + pn.getPm_str().length() <= 160) {
    a += pn.getPm_str();
   }
  else{
   nameGroups.add(a);    
   a="";
   a += pn.getPm_str();
   }
}