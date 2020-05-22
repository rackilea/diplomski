Pattern p = Pattern.compile("*someName*"); // the regexp you want to match

List<String> matchingKeys = new ArrayList<>();
for (String key : map.keySet()) {
    if(p.matcher(key).matches()) {
        matchingKeys.add(key);
    }
}

// matchingKeys now contains the keys that match the regexp