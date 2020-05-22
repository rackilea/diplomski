while ((position =buffRead.readLine()) != null){ // read a line

        String[] splitDash = position.split("-");

        System.out.println(splitDash[0] + " "+ splitDash[1]);
        scannedSavedState.put(splitDash[0], Boolean.parseBoolean(splitDash[1]));

    }