StringTokenizer st = new StringTokenizer(savedString, ",");

for (int i = 0; i < keys.length; i++) {
    if (!st.hasMoreTokens()) break;
    keys[i] = Boolean.valueOf(st.nextToken());
}