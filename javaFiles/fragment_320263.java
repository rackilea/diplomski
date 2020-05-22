b1.setOnClickListener(new View.OnClickListener()
{
   private String originalText = null;

    public void onClick(View v)
    {
        if (originalText == null) originalText = ad1.getText().toString();

        if (ad1.getText().toString().equals(originalText))
        {
            // Setting a new text
            ad1.setText("random text");
        }
        else
        {
            // Setting back the original text
            ad1.setText(originalText);
        }
    }
});