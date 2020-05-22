if(request.getParameter("hidden_id").equals("partial Submit"))
{
  // make a database connection, pass the value user selected from the drop down box
  // to a prepared statement that does the query for getting the 'productName' from 
  // the database, collect the returned string in a variable and set a 
  // request attribute with this returned value. This value can simply be used in the 
  // jsp to fill in the value part of the textbox1.
}
else
{
  if(request.getParameter("hidden_id").equals("final Submit"))
  {
   // do the rest of the final processing that needs to be done when user finally   
   // submits the completed form.
  }
  else
  {
     // throw an exception to take care of the possibility that the user might send 
     // in a 3rd value as a value for the hidden field.
  }
}