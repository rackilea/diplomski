public enum GreetingStyle 
{ 
    HEY {
        public void greet() { /* performs hey style greeting*/ }
    },
    HELLO{
        public void greet() { /* performs hello style greeting*/ }
    };

    public abstract void greet();
}