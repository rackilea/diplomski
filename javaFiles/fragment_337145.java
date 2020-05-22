public class time extends EvalFunc<String>{

public String exec(Tuple input) throws IOException {

    if ((input == null) || (input.size() == 0))
        return null;
    try{
        String time = (String) input.get(0) ;
        DateFormat df = new SimpleDateFormat("hh:mm:ss.000");
        Date date = df.parse(time);
        String timeOfDay = getTimeOfDay(date);
        return timeOfDay;
    } catch (ParseException e) {
        //how will I handle when df.parse(time) fails and throws ParseException?
        //maybe:
        return null;
    }
  } //exec

} //class