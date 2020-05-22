public String[] setwords(){
    int response=-12;
    String[] options = new String[] {"Ok", "Cancel", "Add", "Delete"};
    JPanel[] panel;
    JTextField[] oldword = null;
    JTextField[] newword = null;

    JTextField[] oldwordaux=null;
    JTextField[] newwordaux=null;
    int size=1;
    Boolean firsttime = true;
    Boolean noword = true;

    String[] words;


    while(response!=0 && response!=JOptionPane.CLOSED_OPTION && response!=1){
        panel = new JPanel[size];
        oldword = new JTextField[size];
        newword = new JTextField[size];

        for(int i=0; i<size; i++){
            panel[i] = new JPanel();
            oldword[i] = new JTextField(3);
            newword[i] = new JTextField(3);
            panel[i].add(new JLabel("Change: "));
            panel[i].add(oldword[i]);
            panel[i].add(Box.createHorizontalStrut(15));
            panel[i].add(new JLabel("by: "));
            panel[i].add(newword[i]);
            if(firsttime!=true){
                if(i<oldwordaux.length){
                    oldword[i].setText(oldwordaux[i].getText());
                    newword[i].setText(newwordaux[i].getText());
                }
            }
        }
        firsttime = false;
        response = JOptionPane.showOptionDialog(null, panel, "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(response==2){
            size++;
            oldwordaux=oldword;
            newwordaux=newword;
        }else if(response==3){
            size=(size>1? size-1:size);
            oldwordaux = Arrays.copyOfRange(oldword, 0, size);
            newwordaux = Arrays.copyOfRange(newword, 0, size);
        }
    }

    for(int j=0; j<oldword.length; j++){
        if(oldword[j].getText().length()!=0){
            noword=false;
        }
    }

    if(noword){
        return null;
    }else{
        int w=0;
        words = new String[oldword.length*2];
        for(int i=0; i<oldword.length; i++){
                words[i]=oldword[i].getText();
                w=i+1;
            }
        for(int i=0; i<newword.length; i++){
                words[w]=newword[i].getText();
                w++;
        }
        return words;
    }
}