public static void main(String[] args) throws Exception {
            // manual encoding
        System.out.println(MimeUtility.encodeText("How to include £ pound symbol", "UTF-8", "Q"));
        System.out.println(MimeUtility.encodeText("How to include £ pound symbol", "UTF-8", "B"));

            // MimeMessage encoding
        MimeMessage m = new MimeMessage((Session) null);
        m.setSubject("How to include £ pound symbol", "UTF-8");
        m.setContent("lalala", "text/plain");
        m.writeTo(System.out);
    }