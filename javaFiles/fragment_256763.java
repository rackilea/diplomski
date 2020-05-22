for(j = i + 1; j < nameArray.length; ++j)
{
  JOptionPane.showMessageDialog(null, "Sorry, this name is already "
                + "in our database", "Invalid", JOptionPane.ERROR_MESSAGE);
  input = JOptionPane.showInputDialog(null, "Please enter your name into our"
                    + " database:", "Entry", JOptionPane.QUESTION_MESSAGE);
}