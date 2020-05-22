ActionListener listener = new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
    {

        //correct.setText("correct");

        String action = e.getActionCommand();

        if (action.equals("Incorrect")) {
            reponses[row] = false;
        }
        else {
            responses[row] = true;
            System.out.println("row " + row);
            System.out.println("btn " + action);
        }


    }
};