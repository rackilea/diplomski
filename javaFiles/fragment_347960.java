@Configuration
public class CsvJobConfiguration {

    @Bean
    public FlatFileItemReader cvsFileItemReader() {
        FlatFileItemReader reader = new FlatFileItemReader();
        reader.setResource(new FileSystemResource("C:\\Users\\satish_pahuja\\Desktop\\BO_Office_Acc_Ext.txt"));
        reader.setLineMapper(csvLineMapper());
        return reader;
    }

    @Bean
    public LineMapper<BoOfficeAccExtract> csvLineMapper() {
        DefaultLineMapper<BoOfficeAccExtract> lineMapper = new DefaultLineMapper<BoOfficeAccExtract>();
        lineMapper.setLineTokenizer(csvLineTokenizer());
        lineMapper.setFieldSetMapper(csvFieldSetMapper());
        return lineMapper;
    }

    @Bean
    public LineTokenizer csvLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[] {"extFileName","boId","officeAccountNo","solId" ,"bankId","ind","freeField1","freeField2","freeField3","modifiedBy","createdBy","modifiedDate","createdDate"});
        return lineTokenizer;
    }

    @Bean
    public FieldSetMapper csvFieldSetMapper() {
        BeanWrapperFieldSetMapper<BoOfficeAccExtract> fieldSetMapper = new BeanWrapperFieldSetMapper<BoOfficeAccExtract>();
        fieldSetMapper.setPrototypeBeanName("BoOfficeAccExtract");
        return fieldSetMapper;
    }


}