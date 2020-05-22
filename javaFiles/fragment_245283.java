BufferedReader in = null;
try {
    in = new BufferedReader(new InputStreamReader(con.getInputStream()));
}
catch(IOException e) {
    // handle specific exceptions here
}

int responseCode = -1;
try {
    responseCode = con.getResponseCode();
}
catch(IOException e) {
    // handle specific exceptions here
}

// override the input if you got an error and an error stream is available
if (in==null && responseCode!=200 && con.getErrorStream() != null) {
    in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
}