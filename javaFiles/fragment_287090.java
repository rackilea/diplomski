public int NogAfTeLeggenKm(){ // methode om nog af te leggen km's te berekenen TODO
   int res = 0; 
   for(Wandeldag w2:wandeldagLijst){

       try {
           res=res+Integer.valueOf(w2.getKilometer());
           System.out.println(res);
       }
       catch(NullPointerException e){
           System.out.println("probeer opnieuw");
       }
   }
   return res;

}