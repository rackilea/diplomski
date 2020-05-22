}
            }
        }
    }
    BufferedWriter file = getFile("C:\\ISSUE124_Resolved.txt");

    private void appendFile(boolean continueMe, JLabel jLab0x28, Socket client)
    {   
        try
        {   
            if(!client.isClosed())
            {   
                try
                {   
                    CANDataInfo canData = (CANDataInfo) in.readObject();
                    System.out.println(canData.toString());
                    file.write(canData.toString());
                    file.flush();
                }
                catch (EOFException exp)
                {   
                    continueMe = true;
                    System.out.println("A Stream has finished "+exp.toString()+"\n");
                }
                catch (ClassNotFoundException exp) 
                {
                    exp.printStackTrace();
                    System.err.println(exp.toString());
                    continueMe = false;
                }
            }

            if(!continueMe)
            {
                file.close();
                client.close();
                in.close();