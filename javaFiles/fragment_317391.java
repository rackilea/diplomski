JSONArray event_values = opoutput.getJSONArray("DISPLAY_VALUES");
JSONArray event_codes = opoutput.getJSONArray("VALUES");

List<String> valueList = new ArrayList<String>();
List<String> displayList = new ArrayList<String>();
for(int i=0;i<event_codes.length();i++){
        // if both event_values and event_codes are of equal length
        valueList.add(event_codes.getString(i));
        displayList.add(event_values.getString(i));
    }

int index = valueList.indexOf("ACCPT");
String valueToDisplay = displayList.get(index);