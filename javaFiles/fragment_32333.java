@ComponentScan(
   basePackages = {"my.plugin"},
   includeFilters = @ComponentScan.Filter(
      value= MyPlugin.class, 
      type = FilterType.ANNOTATION
   )
)