int i=1;
int value=1;
String res = "";
while (i <= 10){
  res = value + ((i>1)?",":"") + res;
  value = value * i;
  i++;
}
System.out.print(res);