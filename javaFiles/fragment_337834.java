if(inputWord.equalsIgnoreCase(stack.pop())){
       JOptionPane.showConfirmDialog(null, "This is a Palindrome", "Is this a palindrome ?", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
}
else {
       JOptionPane.showConfirmDialog(null, "This is NOT a Palindrome", "Is this a palindrome ?", JOptionPane.YES_OPTION,JOptionPane.ERROR_MESSAGE);
}