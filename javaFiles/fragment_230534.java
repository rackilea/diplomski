Contact b = new Contact();
                    b.setName(sname);
                    b.setUName(suname);
                    b.setEmail(semail);
                    b.setPass(spass);

                boolean isEmailExist = helper.insertContact(b);