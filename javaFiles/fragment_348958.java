Pattern pattern = Pattern.compile("([^;]*);(.*)");
    while ((line = bufferedReader.readLine()) != null) {
        Matcher matcher = pattern.matcher(line)
        if (matcher.matches()) {
            basebooleanentitieslist.put(matcher.group(1), matcher.group(2));
        }
    }