private List<Button> buttons = new ArrayList<Button>();

// ADD YOUR BUTTONS

private void setSelectionForButtons(boolean enabled)
{
    for(Button button : buttons)
        button.setSelection(enabled);
}