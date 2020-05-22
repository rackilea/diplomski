public static boolean atLeastOneEmpty(String firstString, String... strings){
      if(firstString == null || firstString.isEmpty())
         return true;

      for(String str : strings){
         if(str == null || str.isEmpty())
            return true;
      }
      return false;

    }