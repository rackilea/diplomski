Field[] fields =  R.drawable.class.getFields();
List<String> names = new ArrayList<String>(); 
for (Field field : fields) {
    if(field.getName().startsWith("icon")) 
       names.add(field.getName());    
}

int resid = getResources().getIdentifier(names.get(0), "drawable", "com.org.bla");