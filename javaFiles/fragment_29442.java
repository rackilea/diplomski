BufferedReader in = new BufferedReader(new StringReader(resultJson));

    Pattern regex = Pattern.compile(".*\"link\": \"(.*)\",");
    Collection<String> links = new ArrayList<String>();
    String line = null;
    while ((line = in.readLine()) != null) {
        Matcher matcher = regex.matcher(line);
        if (matcher.matches()) {
            String link = matcher.group(1);
            links.add(link);
        }
    }