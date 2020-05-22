for(String p : password)
{

    if(input.equalsIgnoreCase(p))
    {
        grantedPrompt.setVisible(true);
        deniedPrompt.setVisible(false);
        break; // break out or loop once found
    }
    else
    {
        grantedPrompt.setVisible(false);
        deniedPrompt.setVisible(true);
    }
}