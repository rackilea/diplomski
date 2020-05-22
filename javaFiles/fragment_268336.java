try(DB db = new DB("jdbc:oracle:thin:username/password@10.8.12.6:1521:dev")) {
    String thisString = db.procedure("{call b_pc_mob_portal_pkg.get_pc_lookup_value_second(?,?)}", 
            P.in("TES" , "i_lookup_code"),
            P.out(JDBCType.LONGNVARCHAR , "o_lookup_value" )).call(cs -> cs.getString(2)).orElse("Unknown");
    System.out.println( "thisString String  :" + thisString );

}