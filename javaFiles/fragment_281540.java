VerifyListener listener = new VerifyListener()
{
    @Override
    public void verifyText(VerifyEvent e)
    {
        // Get the source widget
        Text source = (Text) e.getSource();

        // Get the text
        final String oldS = source.getText();
        final String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

        try
        {
            BigDecimal bd = new BigDecimal(newS);
            // value is decimal
            // Test value range
        }
        catch (final NumberFormatException numberFormatException)
        {
            // value is not decimal
            e.doit = false;
        }
    }
};

// Add listener to both texts
text.addVerifyListener(listener);
anotherText.addVerifyListener(listener);