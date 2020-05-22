Scanner in = new Scanner(new File(filename));
    in.useDelimiter("\\s+|,");

    int rows = in.nextInt();
    int cols = in.nextInt();
    // construct the array

    while (in.hasNext()) {
        String type = in.next();
        int r = in.nextInt();
        int c = in.nextInt();
        // read more depending on type
    }