for(int x=0;x<tabla.getRowCount();x++)
{
    int conteo=0;
    for(String valor:vec)
    {
        if(valor.equals(tabla.getValueAt(x, 0)))
        {
            conteo++;
        }
    }