s = s.trim(); // sometimes user inputs white spaces without knowing it
int value;
if (s.length() == 0) {
    value = 0; // obviously not a string
} else {
    try{
        value = Integer.valueOf(s);
    } catch(NumberFormatException e) {
        value = 0;
    }
}

// do whatever you like here