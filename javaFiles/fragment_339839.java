List<String> transactionList = new ArrayList<String>( Arrays.asList("JQ7P00049", "TM7P04797", "RT6P70037") );
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    try {
        // Search the first line
        String lastLine = bufferedReader.readLine();
        for (String transactionIndex : transactionList) {
            if (lastLine.contains(transactionIndex)) {
                System.out.println(transactionIndex + ": true");
            } 
        }
        String currentLine = null;

        // Search the remaining lines
        while((currentLine=bufferedReader.readLine()) != null) {
            String combined = lastLine + currentLine;
            for (String transactionIndex : transactionList) {
                if (currentLine.contains(transactionIndex) || (!lastLine.contains(transactionIndex) && combined.contains(transactionIndex))) {
                    System.out.println(transactionIndex + ": true");
                } 
            }
            lastLine = currentLine;
        }

    } catch ( Exception e ) {
        System.out.println( e.getClass().getSimpleName() + ": " + e.getMessage() );
    } finally {
        bufferedReader.close();
    }