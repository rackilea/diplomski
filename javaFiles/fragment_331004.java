@ComponentScan(
basePackages = {"com.my.package"}, 
useDefaultFilters = false,
includeFilters = {
    @Filter(type = FilterType.ASSIGNABLE_TYPE, value = {MyService.class, MyInjectedService.class})
})