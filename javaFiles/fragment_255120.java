while ((line = reader.readLine()) != null) {

        String[] RowData = line.split(",");
        if(RowData.length <4)
             continue;
        DataStates cur = new DataStates();
        cur.setTitle(RowData[1]);
        cur.setPrice(RowData[2]);
        cur.setDescription(RowData[3]);

        this.add(cur);
    }