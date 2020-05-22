int responseCode = con.getResponseCode();
    InputStream errorStream = con.getErrorStream();//Get the error stream
    if (errorStream != null) {//Read the detailed error message from the stream
        String detailedErrorMessage = getStringFromInputStream(errorStream);
        System.out.println(detailedErrorMessage);
    }