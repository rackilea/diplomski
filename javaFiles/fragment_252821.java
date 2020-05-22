HashSet<String> checks = new HashSet<String>();
checks.addAll(Arrays.asList(check.split(",")));
for (String item : arraylist) {
    if (checks.contains(item)) {
        // Found one
    }
}