public int compare(ObjPerson o1, ObjPerson o2) {
   boolean b1 = o1.select.isChecked();
   boolean b2 = o2.select.isChecked();
   if( b1 && ! b2 ) {
      return +1;
   }
   if( ! b1 && b2 ) {
      return -1;
   }
   return 0;
}