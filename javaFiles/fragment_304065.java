String str = "(form_component_34==\"Yes\"||case_attribute_37==3&&case_attribute_40?has_content)";
    Pattern r = Pattern.compile("(?:form_component_|case_attribute_)\\d+");
    ArrayList<String> matches = new ArrayList<String>(); 
    Matcher m = r.matcher(str);
    while (m.find())
    {
        matches.add(m.group());
    }
    System.out.println(matches);