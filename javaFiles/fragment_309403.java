public ExpectedCondition<Boolean> myCustomCondition(/* some arguments from the outside */) {
return new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            // Check something on the page and return either true or false,
            // this method will be run repeatedly until either the time
            // limit is exceeded, or true is returned
        }

        public String toString() {
            return "a description of what this is waiting for";
        }
    };
}