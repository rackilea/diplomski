public void go()
{
    counter = 0;
        while(go)
    {
        counter++;
        System.out.println(counter);
        try {
            Thread.sleep(1500); //Sleep for 1.5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}