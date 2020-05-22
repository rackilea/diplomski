@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SecurityTestConfig.class)
@AutoConfigureMockMvc
@ActiveProfiles({"test", "test-security-profile"})
@TestInstance(Lifecycle.PER_CLASS)
@Nested
@DisplayName("Inner test")
class InnerTest {
   @Test
   @Sql("/permission.sql")
   void temp() {//here @Sql throws exception}

}