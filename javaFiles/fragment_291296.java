if(c != null)
{
    c.moveToFirst();
    do
    {
        Contenu contenu = new Contenu();
        contenu.setValeur(c.getString(c.getColumnIndex("valeur")));
        test.add(contenu);
    }while(c.moveToNext());
    c.close();
}