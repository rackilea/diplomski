List<String> nameValues = new ArrayList<String>();
    Matcher matcher1 = Pattern.compile("\\\\\"Name\\\\\":\\s\\\\\"[^,}\\]]+\\\\\"").matcher(value);
    while (matcher1.find()) {
        String keyValuePair = matcher1.group();
        String[] keyValue = keyValuePair.split(":");
        String val = keyValue[1].trim();
        System.out.println(keyValue[0]);
        System.out.println(">" + val + "<");
        nameValues.add(val.substring(2, val.length() - 2));
    }
    System.out.println(nameValues);