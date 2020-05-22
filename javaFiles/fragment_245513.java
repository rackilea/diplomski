@Transactional
public void update(ProductDTO dto){
    Product p = productDao.loadById(dto.getId());
    DozerMapper.map(dto,p); //you need to configure dozer to that it only map the fields you want to map.
    productDao.update(p);
}