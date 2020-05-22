// assuming hashes is your array
    Object []hashes;

    for (Object object : hashes) {
        HashMap hash = (HashMap)object;

        for (Object o : hash.values()) {
            System.out.println(o);
        }
    }