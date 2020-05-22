public class WhateverClassThisIs {

    private String username;

    public String getUsername() { return username; }

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String sql = "select * from userinfo where uname=? and pword=?";
        try {
            // As before, but:
            if (rs.next()) {
                username = txt_username.getText();
            }
        }
    }
}

public class SomeOtherClass {

    private WhateverClassThisIs theOtherClass;

    public void setTheOtherClass(WhateverClassThisIs theOtherClass) {
        this.theOtherClass = theOtherClass;
    }

    public void whatever() {
        String username = theOtherClass.getUsername();
    }
}