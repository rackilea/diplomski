public class StandaloneSpringApp{
  public static void main(String[] args){
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    SomeBeanType bean = (SomeBeanType)ctx.getBean("SomeBeanName");
    bean.doProcessing(); // or whatever
  }

}