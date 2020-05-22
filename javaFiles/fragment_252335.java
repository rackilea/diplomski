for(int i = 0; i < tableModel.getRowCount(); i++) {
                    temp = (File) tableModel.getValueAt(i, 0);
                    FileInputStream fis2 = new FileInputStream(temp);
                    FileOutputStream fos2 = new FileOutputStream(dir + "\\"
                            + (temp.getName()));
                    encrypt(key, fis2, fos2);
                }