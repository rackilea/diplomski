@GetMapping("/")
public void str() {

    Cart cart = new Cart("AnonymousCart");

    // Use the returned cart
    cart = cartRepository.saveAndFlush(cart);

    User user = new User("Anonymous", cart);

    // Use the returned user
    user = userRepository.saveAndFlush(user);

    // assign the user to the cart
    cart.setUser(user);

    System.out.println(user + "\n" + cart);
  }
}