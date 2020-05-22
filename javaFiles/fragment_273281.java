if (socket!=null){
        os=socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(name); //filename is also sent to client
        dos.writeLong(filesize); //file size is also sent to client
        long z=filesize;
        int n=0;

        while((z > 0) && (n = dis.read(mybytearray, 0, (int)Math.min(mybytearray.length, z))) != -1){
              dos.write(mybytearray,0,n);
              dos.flush();
              z -= n;
            }
        }
    } catch (FileNotFoundException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }