public String toCSVString () {      // <- c wasn't actually used
    String record = campus + ","    // <- and this. is implied here
                  + course + ","
                  + section + ","
                  + crn + ","
                  + credits + ","
                  + time + ","
                  + days + "\n";
    return record;
}