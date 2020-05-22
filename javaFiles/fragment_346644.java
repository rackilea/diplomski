@Component
public class GeneratorTaskConfigurer extends DefaultTaskConfigurer {

    public GeneratorTaskConfigurer(@Qualifier("dataflowDataSource") DataSource dataSource) {
        super(dataSource);
    }
}