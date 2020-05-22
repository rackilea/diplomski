while (rs.next()) {
            User user = new User();//this should be inside while loop
            user.setF_number(rs.getInt("F_NUMBER"));
            user.setId(rs.getString("ID"));
            user.setFirst_name(rs.getString("FIRST_NAME"));
            user.setMsg_date(rs.getString("MSG_DATE"));
            user.setTopic_id(rs.getInt("TOPIC_ID"));
            user.setMessage(rs.getString("MESSAGE"));
            System.out.println(rs.getString("MESSAGE"));
            users.add(user);
    }