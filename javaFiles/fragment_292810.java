/**
This method loops through datesSmoked ArrayList<GregorianCalendar> and formats each
element with a simpledateformatter named sdf. Then adds the formatted elements to a new  
ArrayList<String> times. Finally it returns the value of the times ArrayList
*/
public ArrayList<String> getDates() {
    for (int i = 0; i < datesSmoked.size(); i++) {
        String s = (sdf.format(i)); // formats each line here
        times.add(s);               // adds the elements to the new ArrayList here
    }
    return times;                   // returns the values from the new ArrayList
}