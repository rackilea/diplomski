public ActionForward execute(----) {
    Dbconnection db=null;
    Connection con=null;
    PreparedStatement pstmt = null; 
    ResultSet rs = null;

    try {
        db=new Dbconnection();//instantiating user defined Dbconnection class object
        con=db.getConnection();//creating connection object

        // some code
        Login_Check formBean = (Login_Check) form;//bean class object

        pstmt = con.prepareStatement("select type from user_registration where user_name=? and password=? and user_status=?");
        //form parameter values
        pstmt.setString(1, formBean.getUname().trim());
        pstmt.setString(2, formBean.getPassword().trim());
        pstmt.setString(3, "Active"); //user status should be active

        rs = pstmt.executeQuery();

        if(rs.next())
        {
            /* some code */
            return mapping.findForward(SUCCESS);//redirecting to success page
        }
        else
        {
            ActionErrors errors = new ActionErrors();
            errors.add("both", new ActionMessage("errors.both.wrong"));//if both user name and password is incorrect, gives an error message
            saveErrors(request,errors);
            return mapping.findForward(FAILURE);//redirecting to failure page
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally {
        db.releaseResultSet(rs);
        db.releasePreparedStatement(pstmt);
        db.releaseConnection(con);
    }

    return mapping.findForward(FAILURE);//redirecting to failure page
  }