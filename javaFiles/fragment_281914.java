public void connectToDB(){
            try {
                conn = DriverManager.getConnection("jdbc:ucanaccess://words.accdb;jackcessOpener=CryptCodecOpener", "user", "pass");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }