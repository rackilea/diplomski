protected void loadColors() throws IOException {
   Map<String, String> colorsHexMap = new TreeMap<String, String>();
   BufferedReader input = new BufferedReader(new FileReader("colors.txt"));
   ...

   Set<String> keySet = colorsHexMap.keySet();
   String[] keyArray = keySet.toArray(new String[keySet.size()]);
   ComboBoxModel<String> model = new DefaultComboBoxModel<>(keyArray);
   CBColor.setModel(model);
}