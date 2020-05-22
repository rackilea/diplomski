String strSqlUpdate = "UPDATE Customers SET Contact = " + contact_num
              + ",Email = '" + email_add + "'" 
              + ",Address = '" + mail_add + "'" 
              + ",SurveyStatus = '" + radio_group + "'"
              + ",Subscription = '" + receive_info + "' " 
              + "WHERE membership_ID = '" + member_ID + "'";