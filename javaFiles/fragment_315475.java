public class Combine extends SwingWorker<Integer,Integer>{

    Folder[] folders; 


    public Combine (Folder[] folders)
    {   this.folders = folders; }       

    private void Merge(Folder [])
    { (for int i=0;i<folder.length;i++)
        {
            merge(folder[i]);
            //Send the message of progress here, it will be executed
            //from doInBackground()
            setProgress(....);
        }

    }
    private void Merge(folder){
        output stream;
    }

    protected Integer doInBackground()
    {
        merge(folders);
        return null;
    }

    protected void done()
    { .... }
}