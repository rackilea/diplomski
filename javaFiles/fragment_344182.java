StringBuilder output = new StringBuilder();
for ( int start = 0; start < str.length(); start += 4 ) {
    try {
        String thisByte = new StringBuilder(str.substring(start, start+4)).reverse().toString();
        output.append((char)Integer.parseInt(thisByte, 16));
    } catch(Exception e) {
        Log.e("MainActivity", e.getMessage());
    }
}