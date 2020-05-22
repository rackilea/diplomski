while (inputStream.available() != 0) {
        line = bufferedReader.readLine();
        String[] tokens = StringUtils.split(line);

        if (tokens.length > 0 && tokens != null) {

            String command = tokens[0];

            // Evaluate the entered command and handle the request accordingly

            if ("login".equalsIgnoreCase(command)) {
                handleLogin(outputStream, tokens);
            } 

            // process other commands ...  

        }
    }