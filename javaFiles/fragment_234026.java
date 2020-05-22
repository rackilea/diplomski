public static void main( String[] args )
{
  ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
  // 'spring.xml' has to add ApplicationContextHolder to its scan path

  ApplicationContext contextFromHolder =
    ApplicationContextHolder.getApplicationContext();
}