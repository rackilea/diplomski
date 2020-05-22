while(true) {
    if (!listening) break;
    if (System.in.available() > 0) {
        try {
            fromUser = stdIn.readLine();
            // etc.