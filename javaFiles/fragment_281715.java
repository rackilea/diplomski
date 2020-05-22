try {
            db = new Database();
            int rows = 0;
            String sql = "INSERT INTO tblStudent (firstName, lastName, username, password, isAdmin) ";
            sql += String.format("VALUES ('%s', '%s', '%s', '%s', %d)", fName, lName, username, passwd, isAdmin);
            System.out.println("Trying " + sql);
            if((rows = db.update(sql)) == 0) {
                System.out.println("Could not create new user");
                throw new Exception();
            }
            System.out.println("Rows " + rows);
        } catch (Exception err) {
            System.out.println("Got err in registerUser: " + err.getMessage());
            return false;
        } finally {
            db.close();
        }