int b=17;
String result = "";
while(b>0)
{
    result = (b%2) + result;
    b=b/2;
}

System.out.println(result);