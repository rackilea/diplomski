Connection c = ods.getConnection();

    String plsql = "declare\r\n" +
        "  cursor tCursor is\r\n" +
        "    select ref_no from CONTROL_TABLE\r\n" +
        "        where status = 'U' for update of STATUS skip locked;\r\n" +
        "  array SYS.ODCIVARCHAR2LIST := new SYS.ODCIVARCHAR2LIST();\r\n" +
        "begin\r\n" +
        "  for tCursorRec in tCursor loop\r\n" +
        "    update CONTROL_TABLE set status='W' where current of tCURSOR;\r\n" +
        "    array.extend();\r\n" +
        "    array(array.count) := tCURSORREC.REF_NO;\r\n" +
        "  end loop;\r\n" +
        "  commit;\r\n" +
        "  ? := array;\r\n" +
        "end;";

    CallableStatement cs = c.prepareCall(plsql);
    cs.registerOutParameter(1, java.sql.Types.ARRAY, "SYS.ODCIVARCHAR2LIST");
    cs.execute();

    String[] refNos = (String[]) cs.getArray(1).getArray();

    cs.close();
    c.close();

    for (String refNo : refNos)
    {
        // Whatever processing you want to do
        System.out.println(refNo);
    }