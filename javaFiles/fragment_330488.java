private void button1_Click(object sender, EventArgs e)
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
    ChangeTextBoxIsEnabled(false);

    //do scan

    ChangeTextBoxIsEnabled(true);
}

private void ChangeTextBoxIsEnabled(bool isEnabled)
{
    if (InvokeRequired)
    {
        Invoke((MethodInvoker)(() => MyTextbox.Enabled = isEnabled));
    }
    else
    {
        MyTextbox.Enabled = isEnabled;
    }
}