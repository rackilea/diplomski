public Action findAction(final String userInput) {
    /* Code to return requested Action if found */
    return new Action() {
        public void doSomething() {
            userConsole.err("Action not found: " + userInput);
        }
    }
}