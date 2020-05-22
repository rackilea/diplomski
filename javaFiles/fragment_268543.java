changeTab(int i){
 tabbedBackground.setSelectedIndex(i);
 tabbedBackground.setEnabledAt(i, false); 
}

public void actionPerformed(ActionEvent e) {
int i = Integer.parseInt(Jbutton.getText());
changeTab(int i); 
        }