@Configuration
public class Conf {

   //define foo1 and 2

    @Bean
    public Bar getBar1() {
        return BarFactory.createBar(foo1)
    }

    @Bean
    public Bar getBar2() {
        return BarFactory.createBar(foo2)
    }

}