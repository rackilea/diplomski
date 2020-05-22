int N=10;

execute
{
var f=new IloOplInputFile("toto.txt");
var str1=f.readline();
var str2=f.readline();
var rank=1;
while (!f.eof)
{
var str=f.readline();
while (str.charAt(0)==" ") str=str.substring(1);
writeln(str);
var ar=new Array(N+1);
var arindex=0;
while (str.indexOf(" ")!=-1)
{
   ar[arindex]=str.substring(0,str.indexOf(" "));
   writeln(ar[arindex]);
   str=str.substring(str.indexOf(" ")+1);
   while (str.charAt(0)==" ") str=str.substring(1);
   arindex++;
}

ar[arindex]=str;
writeln(ar[arindex]);
rank++;
}
f.close();
}