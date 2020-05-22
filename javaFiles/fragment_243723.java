public interface CartRepository extends CrudRepository<ShoppingCart, Integer> {

    @Query("select max(s.itemId) FROM ShoppingCart s")
    public Integer findMaxItemId();

    public List<ShoppingCart> findByCartId(String cartId);

    public ShoppingCart findByItemId(int itemId);
}


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.description = SUBSTRING(p.description, 1,:description_length)")
    List<Product> getAll(@Param("description_length")Integer description_length, Pageable pageable);
}


@RepositoryRestResource
public interface AttributesRepository extends JpaRepository<Attribute, Integer> {

    @Query("select new com.turing.ecommerce.DTO.AttributeDTO(a.attributeId, a.name)"
        + " from Attribute a ")
    List<AttributeDTO> findAllAttributes();
}