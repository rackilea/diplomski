// will contain active fruit
    String currentFruit = null;
    while (true) {
        if (currentFruit == null) {// only read to fruit if there is no active fruit
            currentFruit = reader.readLine();
            if (currentFruit == null) // end of file
                break;
        }

        if (currentFruit != null && isFruit(currentFruit)) {
            // read first line
            String line1 = reader.readLine();
            // check for end of file
            if (line1 == null)
                break;

            // read second line
            String line2 = reader.readLine();
            // check for end of file
            if (line2 == null)
                break;

            // read third line
            String line3 = reader.readLine();
            if (line3 == null || isFruit(line3)) {
                // third line was actually a fruit, so set currentFruit to line3
                // and clear line 3
                currentFruit = line3;
                line3 = null;
            } else {
                // clear fruit
                currentFruit = null;
            }

            // process fruit
            processFruit(currentFruit, line1, line2, line3);
        }
    };