while (inputRequest.available()>0) {
            try {
                int t = inputRequest.read();
                ch = (char) t;
                //here i checked each byte data
            } catch (IOException e) {
            }
    }