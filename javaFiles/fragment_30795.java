public String buildUrl(String baseUrl, String[] getVars) {

    String url = baseUrl + "?";
    // Builds: http://mydomain.com/app?

    for (int i = 0; i < getVars.length; i++) {

        url += "var" + i + "=" + getVars[i];
        // Builds the query string, ...app?var1=lol

        if (i < getVars.length - 1) {

            url += "&";
            // Adds the & after each var except for the last one
            // ...app?var1=lol&
        }

        // repeat for each var until done
        // ... app?var1=lol&var2=cat
    }

    return url;

}