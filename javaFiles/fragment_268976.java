try
    {
        stmt.execute(sql);
            if ((ps1.executeUpdate() == 1)&&(ps2.executeUpdate() == 1)){
                response.setContentType("text");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Your ticket has been cancelled!");
            }
            else{
                response.setContentType("text");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Couldn't Cancel your ticket!");
            }
    }
    catch (Exception e)
    {
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(e.getMessage());
    }