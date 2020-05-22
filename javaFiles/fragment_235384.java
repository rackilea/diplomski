//...

                    while (rs.next()) {

                        blob = rs.getBlob(1);
                        is = blob.getBinaryStream();
                        filepath += "/";

                        for (int c = 2; c <= cols; c++) {
                            filepath += rs.getObject(c).toString() + "_";
                        }
                        filepath = filepath.substring(0,
                                filepath.length() - 1);
                        filepath += fileSuffix;

                        fos = new BufferedOutputStream(new FileOutputStream(filepath));

                        while ((b = is.read()) != -1) {
                            fos.write(b);
                        }

                        filepath = FileOutDir;
                        b = 0;
                    }

 //...