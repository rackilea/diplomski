@Component
public class CustomerFilterConfig {


    public static  Set<String> fieldNames = new HashSet<String>();

      @Bean
      public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
        FilterProvider filters =simpleFilterProvider.setDefaultFilter(SimpleBeanPropertyFilter.filterOutAllExcept(fieldNames)).addFilter("customerFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fieldNames));    
        objectMapper.setFilterProvider(filters);
        return objectMapper;
      } 


}