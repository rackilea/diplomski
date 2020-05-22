public int insertValues(Enumeration<String> params){ // or use Enumeration<?>, but you need 
                                                     // further casting below
    int j = 0;
    while (params.hasMoreElements()) {
        String param = params.nextElement();
        statement.setString(++j, param);
    }
    return statement.executeUpdate();
}