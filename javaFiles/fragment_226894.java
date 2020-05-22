@Override
    public void onResponse(String response) {
        int myNum = 0;
        try {
            response = response.replaceAll("[^0-9]","");
            myNum = Integer.parseInt(response);
        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        reverseTimer(myNum);
    }