int n=lineChar.lenght-1;

//Next 2 lines are edit after comment by @aix
while ((lineChar[n]==',') && (n>=0)) n--;
if (n>=0) System.out.print(lineChar[n--]);

for (;  n >=0;  n-- ) {
  if(lineChar[n] != ',') {
    System.out.print(",");
    System.out.print(lineChar[n]);
  }
}