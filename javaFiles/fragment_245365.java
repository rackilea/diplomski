@PostMapping("/cart")
public Cart create(@RequestBody Map<Integer, Integer> body){
    int productid = body.get("productid");
    String productname=body.get("productname");

    return cartRepository.save(new Cart(productid, productname));
}