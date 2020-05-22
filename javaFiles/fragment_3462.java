public class uploadWorker extends SwingWorker<Integer, Integer>
{
    @Override
        protected Integer doInBackground() throws Exception
        {
                //some codes .....

                try{sftpChannel.put(upload.sourcePath,upload.destPath, new transferProgress()); }
               catch(Exception e){System.out.println(e);}

                Thread.sleep(1000);
                return 42;
        }

        protected void done()
        {

                System.out.print("done");

        }
}