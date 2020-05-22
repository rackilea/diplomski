StringTokenizer t = new StringTokenizer(str," ");
result = t.nextToken();
Boolean first = str.toCharArray()[0]==' ';
Boolean last = str.toCharArray()[str.length()-1]==' ';
while(t.hasMoreTokens())
{
    result += " " + t.nextToken();
}

switch(strMode)
{
    case 0 : if(last) result += " ";
             break;
    case 1 : if(first) result = " " + result;
             break;
}
System.out.println(result);