String collection = "";
for(int i  = 0; i < cihpertext.length; i++) {
    collection += " "+ciphertext[i];
    if(chkEight(i)) [
        collection += "\n"
    }
}
JOptionPane.showMessageDialog(null, collection);