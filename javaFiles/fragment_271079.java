Socket s = new Socket(<<WEB ADDRESS AS STRING>>,<<PORT NO AS INT>>);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //left out a bunch of lines. This is where you should read the lines 
        //of input (with an inner loop) and send stuff back
        s.shutdownInput();
        bw.flush();
        s.shutdownOutput();