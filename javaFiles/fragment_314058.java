String str = "2013-4-25";
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        try {
            SimpleDateFormat parseFormatter = new SimpleDateFormat("yyyy-MM-dd");

            Date date = parseFormatter.parse(str);

            String formattedDate = formatter.format(date);
            System.out.println(formattedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }