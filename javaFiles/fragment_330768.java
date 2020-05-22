ComponentWrapper wrapper = new ComponentWrapper ();
add(wrapper);
revalidate();//if adding 'dynamically'

//later, when you want to get the text
String text = wrapper.getTextArea().getText();