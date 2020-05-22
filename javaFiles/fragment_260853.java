int n=10000;
while(n-->0)
{

int n=100000;
while(n-->0) 
{
turnOnLight();
try{
      Thread.sleep(300);
   }catch(InterruptedException e)
{
      e.printStackTrace();`enter code here`
}
turnOffLight();
Log.d("tagname","runs 10 times  c");
}

}