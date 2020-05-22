public boolean equals(Object that){
   if (this == that) {
      return true;
   }

   if (that instanceof TestClass && this.someVar == ((TestClass) that).someVar ) {
     return true;
   }

   return false;
}