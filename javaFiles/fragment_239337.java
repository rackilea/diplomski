@GetMapping(value = "test/produits/{param}")
public List<Product> testeDeRequetes(@PathVariable String param) {
    // if param is an int...
    //   return productDao.findByPrixGreaterThan(param);
    // else
    //   return productDao.findByNameLike("%"+param+"%");
}