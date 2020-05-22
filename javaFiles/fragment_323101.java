class DamascusShoarma {

    static int Cooksnumber;
    static int Deliverersnumber;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // ... Set delivers, customers etc...

        Cook cook1 = new Cook("Jan de Vries", "Slagersmes 1", "1212-IS",
            "Allahmelo", 123456);
        Cook cook2 =
            new Cook("Sinbad", "Kameelbult 2", "2323-IS", "Halal-lem", 654321);

        Hashmap<String, Cook> cooks = new Hashmap()<String, Cook>;

        cooks.put(cook1.name, cook1);
        cooks.put(cook2.name, cook2);

        Cook cook = null;
        if (args.length > 1 && args.args[1] != null)
        {
            cook = cooks.get(args[1]);  // This is the answer to the question
        }
        // TODO Error check in case cook == null

        cooksnumber = cook.Cooksnumber;  // Used here

        // TODO - do something similar to cooks to select the deliverer
        // and customer
        deliverersnumber = Deliverer.Deliverersnumber;

        deliverer.delivered(cook, customer);  // And here.

    }
}