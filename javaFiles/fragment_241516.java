@RepositoryRestController
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long aLong);
}