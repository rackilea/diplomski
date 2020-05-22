public void run() {

    Socket inSock = null;
    Socket outSock = null;
    try{
        inSock = new Socket(inHost, inPort);
        outSock = new Socket(inHost, inPort);
        /* Set up some socket options here (timeouts, buffers etc)*/

        /* Insert pre copy actions */

        /* This method won't return until inSock's inputStream hits end of stream. 
         * and all the data has been written to outSock's outputStream and flushed. */
        streamCopy(inSock.getInputStream(), outSock.getOutputStream());

        /* In order to really do this correctly you should create an 
         * application protocol that verifies the upstream receiver 
         * is actually getting the data before you close the socket. */

        /* Insert post copy actions */

    }catch(Exception e){
        /* Corrective action or logging here */
    }finally{
        /* Don't forget to close the sockets. */
        if(inSock != null){
            try{
                inSock.close();
            }catch(Exception e){
                /* Don't care */
            }
        }
        if(outSock != null){
            try{
                outSock.close();
            }catch(Exception e){
                /* Don't care */
            }
        }
    }
}