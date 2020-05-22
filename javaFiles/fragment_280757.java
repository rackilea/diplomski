for (int k=0; k<knappar.size();k++)
{
    MyButton button = knappar.get(k);

    if (button != e.getSource())
        button.toggleState();
}