try {
        PreparedStatement STMT_GetCurrentUser = getConnection().prepareStatement("SELECT * FROM Employees WHERE [UserID]='"+STR_UserID+"'");
        ResultSet RSET_GetCurrentUser = STMT_GetCurrentUser.executeQuery();
        if (RSET_GetCurrentUser.next()){
            SYS_Vars.SYS_CurrentUser = RSET_GetCurrentUser.getString(2);
        }
    } catch (SQLException EX_1) {
        EX_1.printStackTrace();
    } catch (ClassNotFoundException EX_2) {
        EX_2.printStackTrace();
    }