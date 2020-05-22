// an interface defines the operations
public interface PizzaService {
  Pizza bakePizza();
}

// standard implementation that contains the business logic
public class PizzaServiceImpl implements PizzaService {
  @Override
  public Pizza bakePizza() {
    // implementation ..
  }
}

// implementation with security constraints that delegates to the real implementation
public class SecurePizzaService implements PizzaService {
  private PizzaService service;
  public SecurePizzaService(PizzaService service) {
    this.service = service;
  }

  @Override
  public Pizza bakePizza() {
    if (!subject.isPermitted("BAKE_PIZZA")){
      throw new UnauthorizedException();
    }
    service.bakePizza()
  }
}

// usage
PizzaService pizzaService = new SecurePizzaService(new PizzaServiceImpl());
...
Pizza pizza = pizzaService.bakePizza();