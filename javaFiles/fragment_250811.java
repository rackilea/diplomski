private SimpleDateFormat dateFormat;
private Date timestart;

public ConstructorOfYourClass{
    timestart = new Date(); //Default date
    //Your prefered date format
    dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 

} 
//... other Code ...


//Getter method of your Date
public String getdateFormat(){
return dateFormat.format(timestart);
}