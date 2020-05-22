// accepts the form request with the myName paramater
public static void greet(String myName) {
    // redirects the user to /users/{myName}
    Application.hello(myName);
}

// welcomes the user by name
public static void hello(String myName) {
    render(myName);
}