public void actionPerformed(ActionEvent evt)
{
    ++indice;
    ExtendedIterator instances = onto.personne.listInstances();
    Individual instance = null;
    Individual firstInstance = null;
    for (p = 0; p < indice && instances.hasNext(); p++) {
        instance = (Individual) instances.next();
        if (firstInstance == null) {
            firstInstance = instance;
        }
    }    
    if (p < indice) {
        indice = 1;
        instance = firstInstance;
    }
    tabTF[0].setText(instance.getPropertyValue(onto.aPourPrenom).toString());
    tabTF[1].setText(instance.getPropertyValue(onto.aPourNom).toString());
    tabTF[2].setText(instance.getPropertyValue(onto.aDateNaiss).toString());
    tabTF[3].setText(instance.getPropertyValue(onto.aGenre).toString());
}