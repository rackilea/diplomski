private void loop(String start, String stop) {
    loop("", start, stop);
}

// Assume start.length==stop.length, and that start<stop at each position
private void loop(String prefix, String start, String stop) {
    if (start.length() > 0) {
        for (int c = start.charAt(0); c <= stop.charAt(0); c++) {
            loop(prefix + (char) c, start.substring(1), stop.substring(1));
        }
    } else {
        System.out.println(prefix);
    }
}