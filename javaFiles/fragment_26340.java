PreparedStatement addmembers = con
                    .prepareStatement("insert into membersdata values "+questionMarks+"");
                  addmembers.setString(2, name);
                  addmembers.setString(3, accounts);
                  addmembers.setString(4, email);
                  addmembers.execute();