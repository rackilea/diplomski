//--- code up to this point runs on the EDT
SwingWorker<Boolean, Void> sw = new SwingWorker<Boolean, Void>()
{

    @Override
    protected Boolean doInBackground()//This is called when you .execute() the SwingWorker instance
    {//Runs on its own thread, thus not "freezing" the interface
        //let's assume that doMyLongComputation() returns true if OK, false if not OK.
        //(I used Boolean, but doInBackground can return whatever you need, an int, a
        //string, whatever)
        if(doMyLongComputation())
        {
            doSomeExtraStuff();
            return true;
        }
        else
        {
            doSomeExtraAlternativeStuff();
            return false;
        }
    }

    @Override
    protected void done()//this is called after doInBackground() has finished
    {//Runs on the EDT
        //Update your swing components here
        if(this.get())//here we take the return value from doInBackground()
            yourLabel.setText("Done loading!");
        else
            yourLabel.setText("Nuclear meltdown in 1 minute...");
        //progressBar.setIndeterminate(false);//decomment if you need it
        //progressBar.setVisible(false);//decomment if you need it
        myButton.setEnabled(true);
    }
};
//---code under this point runs on the EDT
yourLabel.setText("Loading...");
//progressBar.setIndeterminate(true);//decomment if you need it
//progressBar.setVisible(true);//decomment if you need it
myButton.setEnabled(false);//Prevent the user from clicking again before task is finished
sw.execute();
//---Anything you write under here runs on the EDT concurrently to you task, which has now been launched