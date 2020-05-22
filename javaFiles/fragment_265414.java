public Object deserialize(Writable record) throws SerDeException {
        Text text = (Text) record;
        String[] valArray = text.toString().split(",");
        CustomDataFormat dataObject = new CustomDataFormat();
        dataObject.setFname(valArray[0]);
        dataObject.setLname(valArray[1]);

        rows.set(0, dataObject.getFname());
        rows.set(1, dataObject.getLname());
        return rows;
    }