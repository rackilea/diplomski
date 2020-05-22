try {

    if (qry != null) {

        qry = "input=" + URLEncoder.encode(qry, "utf-8"); //This is line 266

    }

} catch (UnsupportedEncodingException e1) {
    e1.printStackTrace();
}