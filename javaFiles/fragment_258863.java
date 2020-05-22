case "get":
        String outGoingFileName;
        while ((outGoingFileName = in.readLine()) != null) {
            sendFile(outGoingFileName);
        }
break;