File temp = new File("C:\\Windows\\Temp\\DIR_"
                                        + TimeZoneUtil.getPdfDate(fromDate) + "_"
                                        + TimeZoneUtil.getPdfDate(toDate) + ".csv");

try (BufferedReader br = new BufferedReader(new FileReader(temp)))
                                {
                                    String isCurrentLine;
                                    while ((isCurrentLine = br.readLine()) != null) {
                                        response.getOutputStream().write("\n".getBytes());
                                        byte[] b = isCurrentLine.getBytes();
                                        response.getOutputStream().write(b);
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }