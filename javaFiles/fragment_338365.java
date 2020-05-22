public class WhateverClassThisIs {

    private SomeOtherClass someOtherClass;

    public WhateverClassThisIs(SomeOtherClass someOtherClass) {
        this.someOtherClass = someOtherClass;
    }

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String sql = "select * from userinfo where uname=? and pword=?";
        try {
            // As before, but:
            if (rs.next()) {
                someOtherClass.setUsername(txt_username.getText());
            }
        }
    }
}

public class SomeOtherClass {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void whatever() {
        // Do something with username--but either try
        // after you know it's been set, or by being
        // able to handle it being null/empty/whatever
    }
}