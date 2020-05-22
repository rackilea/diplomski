String [] fields = line1.split(":");
if( fields.length>1 ){     
    String Movieid = fields[0];
    String line2 = fields[1];
} else {
    // initialize Movieid & line2 tosome default value
    // OR simply put a 'return' statement to skip bad inputs  
}