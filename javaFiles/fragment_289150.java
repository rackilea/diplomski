@Bean
Some s1(){ ... }

@Bean
@DependsOn(["s1"])
Dependable d1(){ ... }