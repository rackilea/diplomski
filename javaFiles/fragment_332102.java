public void itemStateChanged(ItemEvent ie) {
    if(ie.getStateChange() == ItemEvent.SELECTED){
        String temp = stockOptions.getSelectedItem().toString();
        String filePath;

        for(String key : sD.getStock().keySet())  {
            if(temp.equals(sD.getName(key))) {
                filePath = sD.getFilename(key);
            }
        }
    }
}