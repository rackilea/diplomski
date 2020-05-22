Control[] children = comp.getChildren();

for (int i = 0; i < children.length; i++)
{
    if(children[i] instanceof CLabel)
    {
        CLabel label = (CLabel) children[i];

        /* Do something with the label */
    }
}