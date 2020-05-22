@RequestMapping({ "foo", "bar" })
public void method(RequestContextHolder rqh) {

    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    String currentReqUri = attr.getRequest().getRequestURI();

    System.out.println("Your mapping is" + currentReqUri)
}