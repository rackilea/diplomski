jLab0x28.setText("Socket is closed "+client.isClosed());
            }

        }
        catch(IOException exp)
        {
            exp.printStackTrace();
            System.err.println("Exception "+exp.toString());
            jLab0x28.setText(exp.getMessage());
            continueMe = false;
        }
    }

    public BufferedWriter getFile(String path) 
    {
        try 
        {
            File file = new File(path);
            if (!file.exists()) 
            {
                file.createNewFile();
            }