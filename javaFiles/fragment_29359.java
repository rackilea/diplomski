public class MyIni extends Ini
{
/**
 * Constructor.
 */
public MyIni() {
    super();
    // Set a class loader, which is able to resolve your classes!
    Thread.currentThread().setContextClassLoader(new BundleWideClassLoader());
    this.config();

}

@Override
public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("# ").append(this.getClass().getCanonicalName()).append("\n");

    for (String section : this.getSectionNames()) {
        buf.append("\n[").append(section).append("]\n");
        Section s = this.getSection(section);
        for (String key : s.keySet()) {
            buf.append(key).append(" = ").append(s.get(key)).append("\n");
        }
    }

    return buf.toString();
}

@Override
public void load(InputStream iniConfig) {
    // do nothing
}

@Override
public void load(Scanner scanner) {
    //do nothing
}

/**
 * Configure this ini.
 */
private void config() {
    Section main = this.addSection("main");
    main.put("authc.loginUrl", "/login");
    main.put("authc.successUrl", "/");
    main.put("authc.usernameParam", "user");
    main.put("authc.passwordParam", "pass");
    main.put("authc.rememberMeParam", "remember");

    main.put("ds", com.mchange.v2.c3p0.ComboPooledDataSource.class.getCanonicalName());
    ...

    main.put("matcher", org.apache.shiro.authc.credential.HashedCredentialsMatcher.class.getCanonicalName());
    main.put("matcher.hashAlgorithmName", "SHA-256");

    main.put("jdbcRealm", org.apache.shiro.realm.jdbc.JdbcRealm.class.getCanonicalName());
    ...

    main.put("jdbcRealm.dataSource", "$ds");
    main.put("jdbcRealm.credentialsMatcher", "$matcher");
    main.put("securityManager.realms", "$jdbcRealm");

    Section urls = this.addSection("urls");
    urls.put("/VAADIN/**", "anon");
    urls.put("/login/**", "anon");
    urls.put("/login", "authc");
    urls.put("/**", "authc");
}
}