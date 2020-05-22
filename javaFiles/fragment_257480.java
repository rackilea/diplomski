try {
        StringBuilder builder = new StringBuilder();
        reader = new BufferedReader(new 
                        InputStreamReader(tcpSocket.getInputStream()));

        do {
            builder.append(reader.readLine());
        } while((reader.ready()));