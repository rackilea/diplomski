// case 1
long d = 1409012824;
long d1000 = d * 1000; // now returns 1409012824000 correctly

String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    .format(new Date(d1000)); // returns 08/26/2014 08:27:04

// case 2
int d = 1409012824;
long d1000 = d * 1000L; // note the "L" suffix to indicate the number as long 
long d1000f = d * 1000; // FAIL, still returns 263550912 because of integer overflow

String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    .format(new Date(d1000)); // returns 08/26/2014 08:27:04
String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    .format(new Date(d1000f)); // returns 01/04/1970 08:42:30