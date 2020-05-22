public class RobotTest {

    @Test public void t1() throws Exception {
        ApplicationContext ctx = new 
               AnnotationConfigApplicationContext(RobotConfig.class);
        Robot r = ctx.getBean(Robot.class);
        assertEquals("leftLeg_=LeftLeg, rightLeg_=RightLeg", r.toString());
    }
}

@Configuration
class RobotConfig {

   @Bean @Scope("prototype") public Robot robot() {
       return new Robot(leftLeg(), rightLeg());
   }

    @Bean @Scope("prototype") public Leg leftLeg() {
        return new LeftLeg();
    }

    @Bean @Scope("prototype") public Leg rightLeg() {
        return new RightLeg();
    }
}