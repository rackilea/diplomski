void buildUi(L10nService fac, Locale l) {
    JButton btn = new JButton();
    LabelSetter s = R -> btn.setText(R.getText("button.addition.text"));
    fac.addSetter(s);

    // ... continue adding ui elements

   // when you are ready to build: 
   fac.changeLanguage(l);
}