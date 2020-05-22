int ligne = 6;
int colone = 5;

JPanel grille = new JPanel();
grille.setBounds(6, 117, 980, 314);
grille.setLayout(new GridLayout(ligne,colone));
// this could be just a static method call: AddButtonsToPanel()
// doesn't need to be an object
AjouterBouton button = new AjouterBouton(72, grille);