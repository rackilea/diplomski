BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
         BigInteger integer;
        while (line != null) {
            line = line.replace("*","");
            integer = new BigInteger(line);
            //Your stuf
            line = br.readLine();
        }

    } finally {
        br.close();
    }