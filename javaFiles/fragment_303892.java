public void Query() {
        connect();
        if (conn == null) {
            // connection could not be initialized, the error message is 
            // set in connect()
            return;
        }
        Statement comm;
        try {
            comm = conn.createStatement();
            // ...
        } catch (SQLException e) {
            tv.setText(e.toString());
        }
    }