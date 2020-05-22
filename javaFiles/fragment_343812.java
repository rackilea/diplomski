JOptionPane.showMessageDialog(null,"\n\nCiphertext: ");
for (int i = 0; i < ciphertext.length; i++) {

    if (chkEight(i)) {
        System.out.print("\n");
    }
    JOptionPane.showMessageDialog(null,ciphertext[i] + " ");
}