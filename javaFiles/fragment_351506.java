cstmt = db.prepareCall("{ call sample.PACK_USER.get_user_name(?, ?, ?) }");

        cstmt.setString(1,this.getuserid());
        cstmt.registerOutParameter(2,OracleTypes.VARCHAR);
        cstmt.registerOutParameter(3,OracleTypes.VARCHAR);
        cstmt.execute();

        String userName = cstmt.getString(2);
        String ssnType = cstmt.getString(3);