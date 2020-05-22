public String getInfo() {
   String content = "\t" + name + "\t"+ address + "\t\t" + telNo + "\t" + email;
   return content;
}


public class AddressBook
 public void viewAllEntry() {
        String addText = "NO\tNAME\tADDRESS\t\tTEL.NO\tEMAIL\t\n"; /<------HERE
        for (int i = 0; i <  addressBookEntryCounter; i++) {
            addText = addText+(i+1)+ entry[i].getInfo()+ "\n";     /<------HERE
        }
        JOptionPane.showMessageDialog(null, new JTextArea(addText));
    }

}