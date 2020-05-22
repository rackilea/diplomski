public boolean setStuff(Enum unknownEnum, String value) {
     try {
         unknownEnum = Enum.valueOf(unknownEnum.getDeclaringClass(), value);
     } catch (IllegalArgumentException e) {
         return false;
     }
     return true;
 }