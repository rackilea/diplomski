public abstract class org.apache.hadoop.security.UserGroupInformation implements org.apache.hadoop.io.Writable,java.security.Principal {
  public static final org.apache.commons.logging.Log LOG;
  public org.apache.hadoop.security.UserGroupInformation();
  public static org.apache.hadoop.security.UserGroupInformation getCurrentUGI();
  public static void setCurrentUGI(org.apache.hadoop.security.UserGroupInformation);
  static javax.security.auth.Subject getCurrentUser();
  public static void setCurrentUser(org.apache.hadoop.security.UserGroupInformation);
  public abstract java.lang.String getUserName();
  public abstract java.lang.String[] getGroupNames();
  public static org.apache.hadoop.security.UserGroupInformation login(org.apache.hadoop.conf.Configuration) throws javax.security.auth.login.LoginException;
  public static org.apache.hadoop.security.UserGroupInformation readFrom(org.apache.hadoop.conf.Configuration) throws java.io.IOException;
  static {};
}