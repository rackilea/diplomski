@SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(Department.class, DepartmentDTO.class)
                   .addMappings(new PropertyMap<Department, DepartmentDTO>() {
            @Override
            protected void configure() {
                using(new DepartmentStaffListToStaffCountConverter()).map(source.getStaffList(), destination.getStaffCount());
            }
        });
        return modelMapper;
    }
}