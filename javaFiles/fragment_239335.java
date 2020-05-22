@GetMapping(value = "test/produits/")
public List<Product> testeDeRequetes(@RequestParam(name = "prixLimit", required = false) Integer prixLimit,
                                     @RequestParam(name = "recherche", required = false) String recherche {
    // if prixLimit is not null
    //   return productDao.findByPrixGreaterThan(prixLimit);
    // else if recherche is not null
    //   return productDao.findByNameLike("%"+recherche+"%");
    // else
    //   return some meaningful default behavior such as all
    //   products, or return 400 to indicate a bad request
}