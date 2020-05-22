Component[] comp = frame.getContentPane().getComponents();
for(int i=0; i<comp.lenght; i++)
{
    if(comp[i] instanceof JPanel)
    {
        frame.remove(comp[i]);
    }
}