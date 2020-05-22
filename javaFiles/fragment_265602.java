List<String> listOfStrings = Arrays.stream(stringsToEncode)
        .map(s -> {
            try {
                return URLEncoder.encode(s, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError("UTF-8 is unknown");
            }
        })
        .collect(Collectors.toList());