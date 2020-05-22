package com.techvision.MainApp;
    import java.util.HashSet;
    import java.util.Iterator;
    import java.util.Set;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import com.techvision.Util.HibernateUtil;
    import com.techvision.model.Organization;
    import com.techvision.model.Orgperson;
    public class MyApp {
    public static void main (String args[])
    {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    session.beginTransaction();

    Organization org=new Organization();
    org.setOrgname("AZZ");
    Set<Orgperson> orgset=new HashSet<Orgperson>();

    Orgperson orgperson1=new Orgperson();
    Orgperson orgperson2=new Orgperson();

    orgperson1.setPersonname("ravi");
    orgperson2.setPersonname("rams");
    orgperson1.setOrganization(org);
    orgperson2.setOrganization(org);
    orgset.add(orgperson1);
    orgset.add(orgperson2);
    org.setOrgpersons(orgset);
    session.save(org);
    session.getTransaction().commit();
    session.close();
    }
    }