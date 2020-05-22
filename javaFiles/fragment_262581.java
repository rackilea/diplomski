int i = 2;
    for (Entry<Integer, String> entry : map.entrySet()) {
        Label lbl1 = new Label(0, i, entry.getKey().toString());
        Label lbl2 = new Label(1, i, entry.getValue());
        i++;
        wsheet.addCell(lbl1);
        wsheet.addCell(lbl2);
    }
    wworkbook.write();
    wworkbook.close();