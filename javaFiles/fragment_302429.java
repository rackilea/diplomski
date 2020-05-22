public void validate() throws Exception {
    StringBuilder error = new StringBuilder();
    if(paramA == null)
        error.append("paramA was not set");

    if(paramB == null)
        error.append("paramB was not set");

    if(paramC == null)
        error.append("paramC was not set");


    if(error.length() > 0) {

        throw new Exception("error occured " + error.toString());
    }
}