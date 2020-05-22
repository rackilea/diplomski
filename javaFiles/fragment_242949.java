SimpleDateFormat setDateFormat = new SimpleDateFormat ("dd-MM-yyyy");

        try
          {
            Date startDate  = setDateFormat.parse( start_jTextField1.getText()  );
            Date finishDate = setDateFormat.parse( finish_jTextField2.getText() );
            Date check_this_date = setDateFormat.parse( Check_this_Date_jTextField1.getText() );

              System.out.println("Start Date:"+ setDateFormat.format(startDate));
              System.out.println("Finish Date:"+ setDateFormat.format(finishDate));

            if( check_this_date.before(finishDate) && check_this_date.after(startDate))
              {
                  result_jLabel2.setText("Within Range.");
              }
            else if(check_this_date.equals(finishDate) || check_this_date.equals(startDate))
              {
                result_jLabel2.setText("Within Range.");
              }
            else
              {
                 result_jLabel2.setText("Not in rannge.");
              }
          }
        catch(Exception ex)
          {
            ex.printStackTrace();
          }