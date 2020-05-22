if(search.equals("")&& search_tf.equals("")){
                                        sqlPgintn="SELECT SQL_CALC_FOUND_ROWS Id,Company_name,Contact_Person,Address,Phone,Company_Email,Review,Status,Lead_Date,Lead_Details,Lead_Value,followup_Date,Category from marketing_database.lead limit "+iPagNo+","+iSwRws+"";
}
 else if(search.equals("Company Name"))
                                    {   
                                        sqlPgintn="SELECT SQL_CALC_FOUND_ROWS Id,Company_name,Contact_Person,Address,Phone,Company_Email,Review,Status,Lead_Date,Lead_Details,Lead_Value,followup_Date,Category from marketing_database.lead where Company_Name ='"+search_tf+"' limit "+iPagNo+","+iSwRws+"";