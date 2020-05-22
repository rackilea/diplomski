line = streamIn.readLine();
        if (line.equalsIgnoreCase("bye")) {
            done = true;
        } else {
            System.out.println(line);
            streamOut.println(line);
            streamOut.flush();    // or ...checkError();
        }