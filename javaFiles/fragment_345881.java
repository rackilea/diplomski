String time="17:26:54";

SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
Date date=format.parse(time);

...

PreparedStatement stmt = conn
        .prepareStatement("insert into test(message,time) values(?,?)");
stmt.setString(1, "This is message");
stmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
stmt.executeUpdate();