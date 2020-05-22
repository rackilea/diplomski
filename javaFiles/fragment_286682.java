String ts = "2019-01-21T05:56:46.000Z";
String date = ts.split("T")[0];
String[] splitDate = date.split("-");
int day = Integer.parseInt(splitDate[2]);
String month = "";
switch(Integer.parseInt(splitDate[1]))
{
    case 1:
        month = "JAN";
        break;
    case 2:
        month = "FEB";
        break;
    .
    .
    .
}
System.out.println("Day: " + day + ", Month: " + month);