@When("^the login form is submitted$")
public void submitForm() {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(() -> {
        // do submit the form
    });    
}