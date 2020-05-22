System.out.println("Enter Time");
String timeString = br.readLine();
String[] timeArray = timeString.split(":"); //Splits the string with regex ":"

int hour = Integer.parseInt(timeArray[0]);
int minute = Integer.parseInt(timeArray[1]);
int second = Integer.parseInt(timeArray[2]);