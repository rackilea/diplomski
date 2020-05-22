Double coinnum = 0.0;
try {
   coinnum = Double.parseDouble(newcoin);
} catch (NumberFormatException e) {
   coinnum = 0; // your default value
}