byte[] b = {(byte) 01, (byte) 06, (byte) 78, (byte) 140, (byte) 00, (byte) 01, (byte) 158, (byte) 201};

        /*prepare the packet to be sent*/
        for(int count = 0;count<b.length;count++)
        {   
            writeusbdata[count] = b[count];
        }