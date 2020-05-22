ArrayList<String> value_to_get= new ArrayList<String>();
    String  regex= "(\\W|^)_gaq(\\W|$)";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(page_source);

        while(m.find()) {

            if(!value_to_get.contains(m.group())){
            value_to_get.add(m.group())     
        }
       }