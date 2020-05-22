// This can only handle digits
@GetMapping(value = "test/produits/{prixLimit:[0-9]+}")
public List<Product> testeDeRequetes(@PathVariable int prixLimit) {
    return productDao.findByPrixGreaterThan(400);
}

// This can only handle characters
@GetMapping(value = "test/produits/{recherche:[A-Za-z]+}")
public List<Product> testeDeRequetes(@PathVariable String recherche) {
    return productDao.findByNameLike("%"+recherche+"%");
}