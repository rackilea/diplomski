while (!validatePostcode(code)) {
    view.askPostcode(); //simple System.out.println("Input something")
    String postcode = sc_plz.nextLine();
    try {
        code = Integer.parseInt(postcode);
    } catch (NumberFormatException e){
        view.invalidData(); //warning about not got a number
    }
}