driver.get(new URI(driver.getCurrentUrl()).resolve("/questions/question/create").toString());
          WaituntilElementpresent.isExist();
          List<String> enteredQuestions = new ArrayList<String>(); 
          for (int j=1; j <= sheet1.getLastRowNum(); j++)
          {
             /*All your logics go here*/

              if (!enteredQuestions.contains(question_name))
                    {   
                 add_question_page.Add_Question_MI(driver,question_name,question_text,question_type,question_naire);
                 enteredQuestions.add(question_name);
                 WaituntilElementpresent.isExist();

                } //for if

              String parentWindowHandler = driver.getWindowHandle(); 

              add_question_page.Add_Answer_MI(driver);

              WaituntilElementpresent.isExist();

              CallAnswer(driver);

              WaituntilElementpresent.isExist();

              CallAnswerbasedonQuestiontype(driver,question_type, answer_name,answer_value_fillup,answer_value_int,answer_value_deci,answer_weight,answer_comparison,response_text,option_text, option_correct);

              WaituntilElementpresent.isExist();

              add_question_page.Save_Answer_MI(driver,parentWindowHandler);

         }