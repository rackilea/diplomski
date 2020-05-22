while ((line = reader.readLine()) != null) {

        String[] RowData = line.split(",");
        DataStates cur = new DataStates();
        cur.setTitle(RowData[2]);
        cur.setPrice(RowData[3]);
        // now there is a ArrayIndexOutOfBoundsException
        cur.setDescription(RowData[4]);

        this.add(cur);
    }