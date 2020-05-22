public class RobotTest {

    @Test
    public void t1() throws Exception {
        ApplicationContext ctx = new 
               AnnotationConfigApplicationContext(RobotConfig.class, Robot.class);
        Robot r = ctx.getBean(Robot.class);
        assertEquals("leftLeg_=LeftLeg, rightLeg_=RightLeg", r.toString());
    }
}

@Configuration
class RobotConfig {

    @Bean
    public Leg leftLeg() {
        return new LeftLeg();
    }

    @Bean
    public Leg rightLeg() {
        return new RightLeg();
    }

}