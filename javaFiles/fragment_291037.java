class passDatatoTable {
   public void passData() {
      String str1, str2, str3, str4;
      for (int i = 0; i <= 10; i++) {
         str1 = "Column 1 of row: " + i;
         str2 = "Column 2 of row: " + i;
         str3 = "Column 3 of row: " + i;
         str4 = "Column 4 of row: " + i;
         gui SendStringsToGUI = new gui(str1, str2, str3, str4); // **** line (A)
      }
   }
}