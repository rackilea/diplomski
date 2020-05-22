boolean foundPunchIn = false;

while ((line = br.readLine()) != null) {
    if (line.contains(idnumber + " ") && line.endsWith("in")) {
       foundPunchIn = true;
       break;
    }   
}

if(!foundPunchIn) {
    System.out.println("There is no punch-in record for ID number: " + idnumber);
    System.out.println("A punch-in entry must be saved first");
    punchIn();
}

String inorout = "out";
...