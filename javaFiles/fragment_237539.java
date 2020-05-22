public String getText(){
String str;
str = "DMX : ADDRESS  \n";
str += "--- : ---------\n";
int count = mAddress.size();

for (int i = 0; i < count ; i++) //takes up to 3000ms to run
   str += String.format("%03d : %s\n", mAddress.get(i), mBits.get(i));
return str;
}