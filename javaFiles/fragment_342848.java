static void Main(string[] args)
{
    bool createdMutex;

    System.Threading.Mutex mutex = new
    System.Threading.Mutex(true,"myAppMutex",out createdMutex);

    if (!createdMutex)
    {
        MessageBox.Show( "an instance of myApp is already running", "myApp running...");
        return;
    }

    Application.Run();
}