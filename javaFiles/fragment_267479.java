private int[] headerIndexes = null;
    private String[] row = null;

    @Override
    public void rowProcessed(String[] inputRow, ParsingContext context) {
        if(headerIndexes == null){ //initializes the indexes to capture
            processor.processStarted(context);
            String[] parsedHeaders = context.headers();

            LinkedHashSet<Integer> indexes = new LinkedHashSet<Integer>();
            for(String headerToCapture : headersToCapture.keySet()){
                int headerIndex = ArgumentUtils.indexOf(parsedHeaders, headerToCapture);
                if(headerIndex != -1){
                    indexes.add(headerIndex);
                }
            }
            headerIndexes = ArgumentUtils.toIntArray(indexes);
            row = new String[indexes.size()]; //creates a reusable row with the number of columns captured
        }

        //once the input format is known, we can collect the values from the expected positions:
        for(int i = 0; i < headerIndexes.length; i++){
            int indexToCapture = headerIndexes[i];
            if(indexToCapture < inputRow.length){
                row[i] = inputRow[indexToCapture];
            } else {
                row[i] = null;
            }
        }
        //and submit a row with the values in the correct places to the actual bean processor
        processor.rowProcessed(row, context);
    }