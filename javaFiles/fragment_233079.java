@Configuration
@EnableBatchProcessing
public class ExcelBatchConfig extends DefaultBatchConfigurer {

    /**
     * If we don't provide a datasource, an in-memory map will be used.
     */
    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
    }
}