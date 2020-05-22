public void createClic()
{
    for (int i = 0; i < (allsongs.length - 1); i++)
    {
        final Button theButton = b1[i];
        theButton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                testtext.setText(theButton.getText());
            }
        });
    }
}