public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {

    @Query(nativeQuery = true, value = "SELECT PKG_TEST.HELLO_WORLD(:text) FROM dual")
    String callHelloWorld(@Param("text") String text);

}