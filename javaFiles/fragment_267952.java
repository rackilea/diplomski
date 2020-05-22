com.sun.security.jgss.login {
  com.sun.security.auth.module.Krb5LoginModule required
  useKeyTab=true
  storeKey=true
  keyTab=<keytab>
  principal=<principal>;
};
com.sun.security.jgss.initiate {
  com.sun.security.auth.module.Krb5LoginModule required
  useKeyTab=true
  storeKey=true
  keyTab=<keytab>
  principal=<principal>;
};
com.sun.security.jgss.accept {
  com.sun.security.auth.module.Krb5LoginModule required
  useKeyTab=true
  storeKey=true
  keyTab=<keytab>
  principal=<principal>;
};