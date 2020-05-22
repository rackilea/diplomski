String nextLineStr;
while( !((nextLinestr = scan.nextLine()).equals("$")))
{
String tokens [] = nextLineStr.split(" ");
temp1 = Integer.parseInt(tokens[0]);
temp2 = Integer.parseInt(tokens[1]);
addEdge(temp1,temp2);
}