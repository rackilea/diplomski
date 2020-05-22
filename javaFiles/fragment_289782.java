public static class Foo extends DoFn<TableRow, TableRow> {


    @Override
    public void processElement(ProcessContext c) throws JSONException {

        TableRow row = c.element();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();


        long startIp = 0L, endIp = 0L;
        if(row.get("start_ip") != null)
            startIp = Long.parseLong((String)row.get("start_ip"));

        if(row.get("end_ip") != null)
            endIp = Long.parseLong((String)row.get("end_ip"));

        for(long i= startIp; i<=endIp; i++)
        {
            TableRow outputRow = new TableRow();
            outputRow.set("start_ip", startIp);
            outputRow.set("ip", i);

            if(row.get("postal_code") != null && !((String)row.get("postal_code")).isEmpty()){

                endIp = Long.parseLong((String)row.get("end_ip"));

                TableRow atrRow = new TableRow();
                atrRow.set("id", "zippostal_code");
                atrRow.set("value", new String[] {(String)row.get("postal_code")});



                outputRow.set("atr", atrRow);
            }

            System.out.println(outputRow);

            c.output(outputRow);
        }
    }
}