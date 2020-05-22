HashMap<String, ArrayList<Object> > map = new HashMap<String, ArrayList<Object> >();

ArrayList<Object> values = new ArrayList<Object>();
ArrayList<Object> dates = new ArrayList<Object>();

for(int i=0; i < list.size(); i++){
    values.add(resultHours.get(i)[0]);
    dates.add(resultHours.get(i)[1]);
}

map.put("value", values);
map.put("date", dates);