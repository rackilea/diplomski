int diferit = 0;

for(int i=0;i<al.size();i++) {
   Cuvant c = al.get(i);
   for(int j=i+1; j <al.size(); j++) {
      if(c.cuvE.equals(al.get(j).cuvE))
           diferit++;
      }
   }
}