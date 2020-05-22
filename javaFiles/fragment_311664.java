private static String rewriteString(String[] arr, List<String> quantityList) {
    String strOne = arr[0];
    String strTwo = arr[1];
    String newStr = "";
    for(String quantity : quantityList) {
      if(strOne.contains(quantity)) {
        // 8g carrots becomes "8 g carrots"
        newStr = quantity + " " + strOne.substring(quantity.length()) + " " + strTwo;
        break;
      } else if(strTwo.contains(quantity)) {
        newStr = quantity + " " + strTwo.substring(quantity.length()) + " " + strOne;
        break;
      }
    }
    return newStr;
  }