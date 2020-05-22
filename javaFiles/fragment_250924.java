String x[] = {"Cash on hand -4871266","SB Account 976369","Current Account 980980"};
String arr1[] = new String[x.length], arr2[] = new String[x.length];

for(int i=0; i<x.length; i++)
{
    arr1[i] = x[i].substring(0,x[i].lastIndexOf(" ")); //account name
    arr2[i] = x[i].substring(x[i].lastIndexOf(" ")+1); //value
}