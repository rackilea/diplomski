String equation="(a+2)/3*b-(28-c)";
char[] variables= equation.replaceAll("[+*-\\/0-9)(]","").toCharArray();        

  for(int i = 0 ; i < variables.length; ++i)
{
    System.out.println(variables[i]);
}