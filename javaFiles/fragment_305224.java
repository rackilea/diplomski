public void with(Account obj, Withdraw koi){
    this.koi=koi;
    this.obj=obj;
    while (obj.getMoney()<100)
    {
        synchronized(obj) 
        {
            double top= obj.getMoney()-9;
            obj.setMoney(top);
            System.out.println("The balance is : "+obj.getMoney());
        }
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}