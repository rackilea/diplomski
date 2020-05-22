private static void ValidateDecFile(String testStr, ArrayList<String> fcontents) {
  int count = 0;

  String errMsg;
  for(int j = 0; j < testStr.length(); j++) {
      boolean found = false;
      for (int i = 0;i<fcontents.size() && !found;i++) { 
           found = fcontents.get(i).indexOf(testStr.charAt(j)) >= 0;
      }

      if (!found){
          errMsg = "Character '" + testStr.charAt(j) + "' is not in the string.";
    }
  }
}