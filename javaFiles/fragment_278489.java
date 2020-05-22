@Component
class GroupContainerRelationshipDAOImpl {

  @Value("#{dataSourceFactory.dataSource}")
  private DataSource dataSource;

}