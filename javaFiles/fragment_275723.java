public RoseWineForm() {
       JPanel line1 = new JPanel();
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       line1.add(new JLabel("Namn: "));
       line1.add(wineName);
       add(line1);

       JPanel line2 = new JPanel();
       line2.add(new JLabel("Ursprungsland"));
       line2.add(countryBox);
       for(Country c : listOfCountries) {
           //This does the trick
           countryBox.addItem(c);
       }
       add(line2);
  }