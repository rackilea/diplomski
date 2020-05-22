while (con.getConnection().isConnected()) {
            String inString;
            try {
                while ((inString = br.readLine()) != null) {
                    processInput(inString);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }