ArrayList<Button> buttonList= new ArrayList<Button>();
 //put your buttons inside the list in order : buttonList.add(button0);...


for(int i=0;i<position.size();i++){

if(buttonsList.get(i).isEnabled()){
                      buttonList.get(i).setEnabled(false);
                      buttonList.get(i).setBackgroundColor(Color.RED);
             }
  }