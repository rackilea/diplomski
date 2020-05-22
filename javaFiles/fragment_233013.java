public class Row extends ArrayList<Table>{
String applicantName;
int applicantID;


/**
 * Constructor for objects of class Row
 */
public Row(int appID, String appName)
{
applicantName = appName;
applicantID = appID;

}

public getApplicantName(){
return applicantName;
}

public getApplicantID(){
return applicantID; 
}


}