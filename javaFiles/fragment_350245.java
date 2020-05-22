private static class TerminationThread extends Thread
{           
    public void run() {
        System.out.println("Shutdown Initiated...");
        if(!didFinally){
            for(UserCredential user : creds)
            {
                Accel.setRow(user.getMap(), user.getRowIndex());
            }

            System.out.println("Writing to file...");
            try {
                Accel.writeToFile();
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }

        System.out.println("Terminated!");
    }
}