SimpleDateFormat s = new SimpleDateFormat("dd/MMM/yyyy");
String dateInString = "Mon Jul 07 19:18:26 CEST 2014";

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        Date date = s.parse(dateInString.split(" ")[2]+"/"+dateInString.split(" ")[1]+"/"+dateInString.split(" ")[5]);
                        System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(date));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }