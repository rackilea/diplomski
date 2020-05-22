String[] files = filesToCopy.split(","); // filesToCopy is an ArrayList, so I'm not
                                         // sure how this works; I'm assuming it's
                                         // a typo. Just get the files array somehow
String[] merged = new String[2 + files.length];
merged[0] = host;
merged[1] = port;
for (int i = 2; i < merged.length; i++) {
    merged[i] = files[i-2];
}