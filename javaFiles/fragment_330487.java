private void button1_Click(object sender, RoutedEventArgs e)
{
    var thread = new Thread(new ThreadStart(ScannerThreadFunction));
    thread.Start();
}

public void ScannerThreadFunction()
{
    try
    {
        Scan();
    }
    catch (Exception ex)
    {
        //Writing to the console won't be so useful on a desktop app
        //Console.WriteLine(ex.Message);
    }
    finally
    {
    }
}

private void Scan()
{
    Application.Current.Dispatcher.Invoke(DispatcherPriority.Normal,
                                          new Action(() => MyTextbox.IsEnabled = false));

    //do the scan

    Application.Current.Dispatcher.Invoke(DispatcherPriority.Normal,
                              new Action(() => MyTextbox.IsEnabled = true));
}