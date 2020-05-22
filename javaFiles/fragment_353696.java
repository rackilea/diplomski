final int NUMBER_OF_BUTTONS = 50;
final String PREFIX = "btn_";
Field[] fields = getClass().getDeclaredFields();
JButton[] rockets = new JButton[NUMBER_OF_BUTTONS];

for (Field field : fields) {                        
    if(field.getName().startsWith(PREFIX)) {
        int index = Integer.parseInt(field.getName().substring(PREFIX.length())) - 1;
        rockets[index] = (JButton) field.get(this);
    }           
}