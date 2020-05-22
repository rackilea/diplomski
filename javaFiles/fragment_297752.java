String[] comEdit = request.getParameterValues("editIDCom");   
int[] comEditDels = null;

if (comEdit != null) {
    comEditDels = new int[comEdit.length];

    for (int i = 0; i < comEdit.length; ++i) {
        String com = comEdit[i];
        if (com != null && com.length() - 3 > 0) {
            try {
                comEditDels[i] = Integer.parseInt(com.substring(0, com.length() - 3));
            } catch (NumberFormatException exception) {
                // do something or possibly ignore since the value isn't a valid integer
            }
        }
    }
}

if (comEditDels != null) {
    CallableStatement stmt = null;
    PreparedStatement pstmt = null;
    Connection conn = null;
    ArrayDescriptor ad = null;
    String dSource = getServletContext().getInitParameter("dataSource");

    stmt = conn.prepareCall("{?= call My_function(?,?,?,?)}");
    stmt.registerOutParameter(1, Types.INTEGER);
    ad = ArrayDescriptor.createDescriptor("NUM_ARRAY", conn);
    stmt.setArray(2,new ARRAY(ad, conn, comEditDels));
}