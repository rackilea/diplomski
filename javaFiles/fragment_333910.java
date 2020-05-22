try {


                    String[] header = { "Name", "Phone", "Street","State","City","Zipcode" };
                    Elements infobox = doc.select(".info");

                    if(count == 0){

                        writer.writeNext(header);
                    }

                    for(int i = 0; i < infobox.size(); i++){



                        infobox.get(i).select(".business-name > span");

                        String businessName = infobox.get(i).select(".business-name > span").text();
                        String phone = infobox.get(i).select(".phones.phone.primary").text();
                        String address = infobox.get(i).select(".street-address").text();
                        //Address seems to be displayed another way too
                        String address2 = infobox.get(i).select(".adr").text();
                        //Use regular expression to normalize data


                        String[] columns = new String[]{
                                businessName, phone, address
                        };

                        writer.writeNext(columns);


                    }

                    writer.close();
                }