@Repository
 public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    public Optional<ProductImage> findByProductAndDevice(Product product, Device device);

}