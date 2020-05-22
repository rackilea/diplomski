StringTokenizer tokenize = new StringTokenizer(receivedFromClient, "#");

        try {
            String recipient = tokenize.nextToken();

            int recipientID = Integer.parseInt(tokenize.nextToken());
            String message = tokenize.nextToken();
        } catch (RuntimeException e) {

            //ask client to resend the data
            continue
        }