@Bean
public abstract ValidationDelegate getValidationDelegate();

public void doUpdate() {    
    if (!getValidationDelegate().getHasErrors()) {
        // business logic
    }
}