calendar=java.util.Calendar.getInstance();
calendar.setTime(chosen_date);

//we must add 1 here beacause Calendar intialise months by zero
int month= calendar.get(Calendar.MONTH)+1;

//we get the year
int year= calendar.get(Calendar.YEAR);

String req = "SELECT count(*) from doc_arriv where
EXTRACT(month FROM month_arv) = " +  month + 
"and   EXTRACT(year FROM month_arv)= " = year ;

Resultset res=st.executeQuery(req);
res.next();

//continue your code here you must calculate the result of the request if more than 1 you insert else you dont insert and for change the day to the first day of month you must execute the code 

 calendar.set(Calendar.DAY_OF_MONTH, 1);
chosen_date= calendar.getTime();

//good luck