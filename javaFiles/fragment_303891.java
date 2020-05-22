public void connect() throws Exception {
        // ...
        conn = DriverManager.getConnection(/* ... */);
    }

    public void Query() {
        try {
            connect();
        } catch (Exception e) {
            // handle the error (i.e. show error message)
            return;
        }
        // ...
        try {
            comm = conn.createStatement();
            // ...
        } catch (SQLException e) {
            tv.setText(e.toString());
        }
    }