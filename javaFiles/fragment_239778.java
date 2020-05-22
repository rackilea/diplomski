@Around("performance() && this(encoreable)")
public void wrapPerformance(ProceedingJoinPoint jp, Encoreable encoreable) {
  try {
    silenceMobilePhones();
    takeSeats();
    encoreable.performEncore();
    jp.proceed();
    applause();
  } catch (Throwable e) {
    System.out.println(e);
    e.printStackTrace();
    demandRefund();
  }
}