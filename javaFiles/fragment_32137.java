public NewBeautifulKiwi setKiwi(String Kiwi) {
    this.Kiwi = Kiwi;
    return this;
}

//Now that will compile
NewBeautifulKiwi newBeautifulKiwi = new NewBeautifulKiwi().setKiwi(KIWITextField.getText());