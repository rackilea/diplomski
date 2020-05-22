class ACustomJEditText extends JTextField{
ArrayList<String> realText=new ArrayList<String>();
String displayText="";

public ACustomJEditText() {
    // TODO Auto-generated constructor stub
    super();
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {

            // DELETE TEXT on backspace
            if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                if(realText!=null && realText.isEmpty()==false) {
                    realText.remove(realText.size()-1);//remove character
                }
                turnRealTextToString();
                //set the display text here
                setText(displayText);
                return;
            }

            //avoid any input if string actually string size is greater than 16
            if(realText.size()==16) {
                setText(displayText);
                return;
            }

            //other keys should now be added to the input for only numbers
            try{
                int input=Integer.parseInt(e.getKeyChar()+"");
                //add int to realtext
                realText.add(input+"");
                //turn real text to ####********#### string
                turnRealTextToString();
                setText(displayText);
            }catch (Exception ex) {
                // Other keys fail.
                setText(displayText);
            }
        }

        private void turnRealTextToString() {
            String result="";
            for(int i=0;i<realText.size();i++) {
                if(i>3 && i<12) {
                    result+="*";
                }else {
                    result+=realText.get(i);
                }

            }
            String realDisplay=realText.toString();
            System.out.println("DISPLAY: "+result+" REAL: "+getRealText());

            //set result to display text
            displayText=result;
            setText(displayText);
        }
    });
}

//get the actual real text
public String getRealText() {
    StringBuilder real=new StringBuilder();
    realText.forEach(text->{
        real.append(text);
    });

    return real.toString();
}