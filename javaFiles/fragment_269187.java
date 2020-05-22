List<Document> matrixes = coll.find().into(new ArrayList<Document>());

        ArrayList<Double> myArray = new ArrayList<Double>();

        for (Document matrix : matrixes) {

            Double column1 = matrix.getDouble("column1");
            myArray.add(column1);
            Double column2 = matrix.getDouble("column2");
            myArray.add(column2);
            Double column3 = matrix.getDouble("column3");
            myArray.add(column3);
            Double column4 = matrix.getDouble("column4");
            myArray.add(column4);
            Double column5 = matrik.getDouble("column5");
            myArray.add(column5);
        }

        myArray.toArray();