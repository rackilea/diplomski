public LString replace(int start, int end, LString replacement){
   //Do exception checks for start/end values here

   LString replacedLs = new LString();
   replacedLs.append(substring(0, start));
   replacedLs.append(replacement);
   replacedLs.append(substring(end, this.length));
   return replacedLs;
}