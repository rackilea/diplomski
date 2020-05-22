int i=1;
int value=1;
String res = "";
while (i <= 9){
  value = value * i;
  res = value + ((i>1)?",":"") + res;
  i++;
}
System.out.print(res);