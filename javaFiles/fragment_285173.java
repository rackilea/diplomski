HashSet<String> seenParents = new HashSet<String>();

if (audioCursor.moveToFirst()) {
    final int fileparent = audioCursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.PARENT);
    do {
        String parent = audioCursor.getString(fileparent);

        Mediafileinfo info = new Mediafileinfo();
        // bla...
        info.setParent(parent);

        if (!seenParents.contains(parent)) { // prevents dups
            seenParents.add(parent);
            audioList.add(info);
        }

// end loop