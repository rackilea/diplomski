int day = Integer.parseInt(zodiacDay);  // throws an unchecked exception
                                        // if 'zodiacDay' is not a valid
                                        // integer representation.
if (zodiacMonth.equals("January") && day >= 20 && day <= 26) {
    this.dispose();
    new Aquarius().setVisible(true);
}