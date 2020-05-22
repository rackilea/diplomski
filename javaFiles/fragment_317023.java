String[] mpk;

mpk= request.getParameterValues("mpk");
for(int i = 0; i < mpk.length; i++)
{
System.out.println(mpk[i]);
}