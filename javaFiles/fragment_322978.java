public void actionPerformed(ActionEvent event)
{
    // Save transactions to file
    if(event.getSource()== buttonSaveTransaction)
    {
        try
        {
            customHandler.saveTransactionToFile();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
   }
}