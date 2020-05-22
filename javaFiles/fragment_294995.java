public class ThreadListener
{   
    Socket client = null;
    ObjectInputStream in = null;
    ListenFor0X28 runnableListenFor0X28 = null;
    boolean continueMe;


    public class ListenFor0X28 implements Runnable 
    {   
        JLabel jLab0x28; 

        public ListenFor0X28(){}

        public ListenFor0X28(boolean stop, JLabel jLab0x28) 
        {
            continueMe = stop;
            this.jLab0x28 = jLab0x28;
        }

        public void run() 
        {   

            while(continueMe)
            {
                try
                {
                    client = new Socket("localhost", 38301);
                    in = new ObjectInputStream(client.getInputStream());
                    if(client.isConnected())