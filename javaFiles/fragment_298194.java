public Socket accept() throws IOException {
         if (isClosed())
              throw new SocketException("Socket is closed");
           if (!isBound())
                throw new SocketException("Socket is not bound yet");
            Socket s = new MySocket((MySocketImpl) null);
            implAccept(s);
            return s;
     }