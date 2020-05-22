Integer timeCount =  (int) (millisUntilFinished/1000);
int min = timeCount / 60;
int  sec = timeCount % 60;
String textMin = (min < 10 ? "0"+min : min+"" );
String textSec = (sec < 10 ? "0"+sec : sec+"" );
textView.setText(textMin + ":" +  textSec );