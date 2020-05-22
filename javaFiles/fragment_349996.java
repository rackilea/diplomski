class String {
   int hashCode = 0;

   public int hashCode(){
       if(hashCode==0){
           hashCode = deriveHashCode();
    }
       return hashCode;
   }
}