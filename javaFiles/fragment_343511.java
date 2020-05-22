public class App {
    Bank b = new Bank(); // the model
    //... do things with b here

    View view = new View(b); // pass the model in
    // and then in View's constructor use the model

}