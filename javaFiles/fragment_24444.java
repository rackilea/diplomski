@ComponentScan(
    basePackages = {"mypackage"}, 
    excludeFilters = 
        @ComponentScan.Filter(
            type = FilterType.ANNOTATION, 
            value = Configuration.class
        )
)