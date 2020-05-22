ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt((int)(md.time/1000));
        dos.close();
        byte[] timeBytes = baos.toByteArray();


        ByteBuffer buf = ByteBuffer.allocate(5);
        buf.put((byte) 0xd2);//header
        buf.put(timeBytes);//time value (int32 bytes not uint32)