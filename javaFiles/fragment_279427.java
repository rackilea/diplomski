Properties propsTest1 = (Properties)test1Source.getSource();

for(Map.Entry<Object, Object> e : propsTest1.entrySet()){

   String value = (String)e.getValue();
   String[] values = value.split(",");
   // If you have spaces as between values, you have to take care of it.
}