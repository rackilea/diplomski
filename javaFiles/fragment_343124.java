@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {   

    @Override
    public void setDataSource(DataSource dataSource) {
        //This BatchConfigurer ignores any DataSource
    }
}