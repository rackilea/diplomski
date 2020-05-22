public static getAusloesungsartWithValue(Integer code){
   for (Ausloesungsart current : values()){
      if (current.numericValue.equals(code)){
         return new AusloesungsartWithValue(current, code);
      }
   }

    return new AusloesungsartWithValue(UNDEFINED, code);
}