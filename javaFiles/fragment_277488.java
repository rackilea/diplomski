public static void main(String[] args) {
    try {

         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@...", "username", "password");

         String plsql =
                        "declare cur_data SYS_REFCURSOR;\n" +
                        "BEGIN\n" +
                        "OPEN cur_data FOR select '000000' inn, 'Ch' lastname from dual;\n" +
                        "END;\n" +
                        "merge_objects('tbl_o_persons',\n" +
                        "                '19863572,19863598',\n" +
                        "                cur_data);\n" +
                        "CLOSE cur_data;\n" +
                        "end;";

        try (PreparedStatement stmt = conn.prepareStatement(plsql)) {
            stmt.execute();
        }

        conn.close();

    }catch(Exception ex){
        System.out.println("Error: " + ex.toString());
    }
}