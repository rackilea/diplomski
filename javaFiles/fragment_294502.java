Set<Integer> toRemoveCodes = new HashSet<Integer>(Arrays.asList(1, 2, 3));
for (Iterator<ValidColumnKey> it = this.getColumnCustomer().iterator(); it.hasNext(); ) {
   ValidColumnKey curColumnKey = it.next();
   Integer code = curColumnKey.codigo();
   if (toRemoveCodes.contains(code)) {
       it.remove();
   } 

}