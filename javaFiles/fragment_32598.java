int row_desired = 123;
    int row_counter = 0;
    while ((line = br.readLine()) != null) {
        if (row_counter++ == row_desired) {
            String twitter[] = line.split(cvsSplitBy);
            System.out.println(twitter[2]);
        }
    }