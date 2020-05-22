Integer[] count = new Integer[]{1,2,3,4,5,6,7,8,9,10}; //maximum of 10 Checkboxes
        size = mFrageList.get(position).getAuswahlList().size();
        for (int i = 0; i < size; i++) {
            cBox = new CheckBox(this);
            cBox.setText(mFrageList.get(position).getAuswahlList().get(i));
            cBox.setId(count[i]);

            try{ //this is where the magic happens
                if(antwortencode[position] != ""){ //cause i won´t want null in my db i´ve set "" as standard string in my activity for the List<String>
                    String code = antwortencode[position];
                    char[] c = code.toCharArray();
                    for(int j=0;j<=c.length;j++){
                        int x = c[j] -'0'; // 'char 1' - 'char 0' = Integer 1 , lol
                        if(cBox.getId()== x){ //compare them
                            cBox.toggle(); //if it fits, toggle
                        }
                    }
                }
            } catch (Exception e){
                    e.printStackTrace();
            } //and here it ends

            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(isChecked){
                        antwortencode[position] += "" + buttonView.getId();
                        frageBeantworten.setText("Antwort :"+antwortencode[position]+" abgeben");

                    } else {
                        String id = Integer.toString(buttonView.getId());
                        antwortencode[position] = antwortencode[position].replaceAll(id,"");
                        if(!antwortencode[position].isEmpty() || antwortencode[position]!= "") {
                            frageBeantworten.setText("Antwort :" + antwortencode[position] + " abgeben");
                        } else {
                            frageBeantworten.setText("Keine Checkbox(en) gewählt");
                        }
                    }
                }
            });

            antworten.addView(cBox);