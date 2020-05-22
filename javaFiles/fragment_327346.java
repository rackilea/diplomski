jcbo.addActionListener (new ActionListener () {
public void actionPerformed(ActionEvent e) {
String selected=""+jcbo.getSelectedItem();
if(selected.equals("Senior"))
   System.out.println("Student has been in school for four years")
else if(selected.equals("Junior"))
   System.out.println("Student has been in school for three years");
    }
});