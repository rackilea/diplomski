List<String> choices = Arrays.asList(new String[] { "Library", "School Office", 
       "Science Dept" });
String selected = "Library";
IModel dropdownModel = new Model<String>(choices[0]);
DropDownChoice<String> serviceDDC = 
        new DropDownChoice<String>("service",  dropdownModel, choices);