String name1 = "alpha";
String name2 = "delta";

name1 = name1.toLowerCase();
name2 = name2.toLowerCase();


StringBuilder sb1 = new StringBuilder(name1);
StringBuilder sb2 = new StringBuilder(name2);

for(int i=0; i<sb1.length();i++)
{
for(int j=0; j<sb2.length(); j++)
{

    if(sb1.charAt(i) == sb2.charAt(j))
    {
        sb1.replace(i, i+1, "0");
        sb2.replace(j,j+1,"0");
    }
}
}

String s = sb1.toString();
String t = sb2.toString();
for(int i=0;i<s.length();i++){
    if(s.charAt(i)!='0'){
    System.out.print(s.charAt(i));
    }
}
    System.out.println();
for(int i=0;i<s.length();i++){
    if(t.charAt(i)!='0'){
    System.out.print(t.charAt(i));
    }
}