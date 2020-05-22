for(String[] output : allRows) {

        //get current row
        String[] parsedRow=new String[output.length];
        for(int i=0;i<output.length;i++){
            //parse each column
            parsedRow[i]=output[i].replace("[", "");
        }

        //write line
        writer.writeNext(parsedRow);


    }
    writer.close();