public static String appContext;    // My problem .. see question above...now resolved

 static{
  appContext = SpringBean.getInstance().getBean("appContext").toString();
  init();
  }