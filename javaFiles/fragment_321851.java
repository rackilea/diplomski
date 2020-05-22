IDfUser dfcUser = (IDfUser) getSession().newObject("dm_user");
        dfcUser.setUserName("username");
        dfcUser.setUserLoginName("username");

        dfcUser.setString("user_source","inline password");
        dfcUser.setString("user_password","somepassword");
        dfcUser.setString("user_os_name","username");
        dfcUser.setString("description","new user description");