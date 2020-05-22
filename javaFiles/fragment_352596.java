public static String toCSVString (Course c) {
    String record = c.campus + "," 
                  + c.course + ","
                  + c.section + ","
                  + c.crn + ","
                  + c.credits + ","
                  + c.time + ","
                  + c.days + "\n";
    return record;
}