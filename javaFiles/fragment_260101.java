package mypackage;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.HibernateException;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

public class RandomIdentifierGenerator implements IdentifierGenerator {

  private final static SecureRandom sr = new SecureRandom();

  public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
    long val = sr.nextLong();
    return Long.toString(Math.abs(val), Character.MAX_RADIX);
  }
}