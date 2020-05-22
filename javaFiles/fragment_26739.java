int previous_question_no;
    String chosenAnswer="";
    if(request.getParameter("button")!=null)
    {
    chosenAnswer=request.getParameter("button").toString();
    //getting question no which is submitted
    previous_question_no=Integer.parseInt(request.getParameter("current_question"));

    }
   //Calling procedure to obtain the CorrectAnswer from database
    CallableStatement stmt2 = conn.prepareCall("{call GetCorrectAnswer(?, ?)}");
   //passing same question no 
        stmt2.setInt(1, previous_question_no); 
        stmt2.registerOutParameter(2, Types.VARCHAR);
        ..