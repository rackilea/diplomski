groupByMap.values().forEach(fileWriter -> {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace(); //Add appropriate error handling
        }
    });