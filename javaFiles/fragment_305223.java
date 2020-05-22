public void add(Account obj, Add koi){
    this.obj=obj;
    this.koi=koi;
    while(obj.getMoney()<100)
    {
        synchronized(obj)
        {
            double top= obj.getMoney()+10;
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