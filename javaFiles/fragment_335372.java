setConnection(); //IT IS OK, SO DONT WORRY!! =)

String insert = "insert into DATABASE.TABLE (START_DATE , STATUS, PROCESS)";

PreparedStatement  pstm = getConnection().prepareStatement(insert);

Calendar calendar = Calendar.getInstance();
Timestamp ts =  new java.sql.Timestamp(calendar.getTime().getTime());
String mydate = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(ts);

ArrayList<Object> values = new ArrayList<Object>();

values.add(0, mydate);

values.add(1, new Integer(0));
values.add(2, "TEST_PROCESS");

for (int i = 0; i < values.size(); i++)
{
    if (values.get(i).getClass().equals(Integer.class))
        pstm.setInt(i+1, (Integer) values.get(i));

    if (values.get(i).getClass().equals(String.class))
        pstm.setString(i+1, (String) values.get(i));

    if (values.get(i).getClass().equals(Timestamp.class))
        pstm.setTimestamp(i+1, (Timestamp) values.get(i));

    if (values.get(i).getClass().equals(Date.class))
        pstm.setDate(i+1, (Date) values.get(i));

    if (values.get(i).getClass().equals(Double.class))
        pstm.setDouble(i+1, (Double) values.get(i));

    if (values.get(i).getClass().equals(Float.class))
        pstm.setFloat(i+1, (Float) values.get(i));
}

pstm.execute();