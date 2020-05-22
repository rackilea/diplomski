String str = "SP003-SP456.zip";
int xxx, yyy;

try {
    int xxx = Integer.parseInt(str.substring(2, 5));
}
catch(NumberFormatException e) {
   xxx = 0;
}

try {
    int yyy = Integer.parseInt(str.substring(8, 11));
}
catch(NumberFormatException e) {
   yyy = 0;
}