ObjectImpl. Classtouse = refelct in the class to use here from properties file
List(String[]) fieldarray = the raw data taken in and converted to a list of string arrays
String[] firstline = fieldarray.getfirstline()
List(String[]) restoflines = fieldarray.getallotherlines()
for i = 0, i > firstline.size(), i++{
    Fieldmap.put(Name of the field from firstline[i], create a new Field object here with the Name);
    Field fieldtoset = Fieldmap.get(Name of the field again)
    fieldtoset.set(make an instance of the Classtouse here, restoflines[i] which represents the data in the 'Name' column)