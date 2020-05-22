public static void main( String[] args ){
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    ArrayList<GoBean> goBeans = new ArrayList<GoBean>();
    goBeans.add((GoBean) ctx.getBean("goBean1"));
    goBeans.add((GoBean) ctx.getBean("goBean2"));
    goBeans.add((GoBean) ctx.getBean("goBean3"));

    for(GoBean g: goBeans){
        g.execute();
    }
}