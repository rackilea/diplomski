OutputStreamWriter dOut = new OutputStreamWriter(connectionToServer.getOutputStream());
        while(true) {
            String input = System.console().readLine() + "\n";
            dOut.write(input, 0, input.length());
        }
        dOut.close();