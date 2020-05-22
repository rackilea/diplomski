try {

        String str_input = "Friday-2015-August-07";

        SimpleDateFormat format = new SimpleDateFormat("EEEE-yyyy-MMMM-dd");
        SimpleDateFormat formatTarget = new SimpleDateFormat("yyyy-MM-dd");
        String str_output=formatTarget.format(format.parse(str_input));

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }