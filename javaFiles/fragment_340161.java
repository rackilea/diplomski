public class ThreadLocalHolder {

  private static ThreadLocal<String> tenantIdThreadLocal = new ThreadLocal<>();

  public static String getTenantId(){
    return tenantIdThreadLocal.get();
  }
  public static void setTenantId(String tenantid){
    return tenantIdThreadLocal.set(tenantid);
  }
}