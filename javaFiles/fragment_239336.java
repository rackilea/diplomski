@GetMapping(value = "test/produits/prixLimit/{prixLimit}")
public List<Product> testeDeRequetes(@PathVariable int prixLimit) {
    return productDao.findByPrixGreaterThan(prixLimit);
}

@GetMapping(value = "test/produits/recherche/{recherche}")
public List<Product> testeDeRequetes(@PathVariable String recherche) {
    return productDao.findByNameLike("%"+recherche+"%");
}