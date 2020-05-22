int total = 0;
String inputString = "12 7 8 9 52";
int prevIndex = 0;
int index = 0;
while (index > -1) {
  index = inputString.indexOf(' ', prevIndex);
  if (index > -1) {
    total += Integer.parseInt(inputString.substring(prevIndex, index));
    prevIndex = index + 1;
  } else {
    total += Integer.parseInt(inputString.substring(inputString.lastIndexOf(' ')+1));
break;
  }
}
System.out.println(total);