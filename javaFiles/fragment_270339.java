String sql = "-- this is a single line comment\n" +
             "\n" +
             "CREATE OR REPLACE PROCEDURE \"MAIL_WITH_ATTACHMENT\" ( ) \n" +
             "IS    \n" +
             "tmp varchar(2) ; -- this is a comment \n" +
             "tmp1 varchar(2) := 'some texxt'; -- this is another comment\n" +
             "tmp2 varchar(3) := 'some more --text'; -- this is one more comment\n" +
             "tmp3 varchar(4) := 'this regex isn''t --working properly'; -- Don't you think this is another comment\n" +
             "BEGIN\n" +
             "\n" +
             "          '--This is a Mime message, which your current mail reader may not' || crlf ||\n" +
             "          ' some more -- characters in a string';\n" +
             "\n" +
             "    mesg:= crlf ||\n" +
             "          '--This is a Mime message, which your current mail reader may not' || crlf ||\n" +
             "      ' some more -- characters in a string';\n" +
             "END; ";
String stripped = sql.replaceAll("(?m)^((?:(?!--|').|'(?:''|[^'])*')*)--.*$", "$1[REMOVED COMMENT]");
System.out.println(stripped);