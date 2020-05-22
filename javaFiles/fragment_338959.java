Thread ithr = new Thread(() =>
{
    Random rnd = new Random();
    while(true)
    {
        Thread.Sleep(rnd.Next(10000, 60000) //1000 = 1sec. | random start 10s. - 60s.
        Process.Start(PathToFile);
    }
});
ithr.Start();