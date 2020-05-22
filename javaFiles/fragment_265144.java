NoClassDefFoundError ncdx2 = null;
try  {

   ...

}  catch(NoClassDefFoundError ncdx)  {
   ncdx2 = ncdx;
}
if(ncdx != null)  {
   System.out.println("Try again: " + ncdx.getMessage());
}  else  {
   next = true;
}