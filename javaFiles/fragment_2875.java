int value = 0;
String incHex = "";

for (int i = 0; i == data.length(); i+=2){
  valueInt += Integer.parseInt(hex, data.substring(i, i+2));
}
resultHex = Integer.toHexString(valueInt);