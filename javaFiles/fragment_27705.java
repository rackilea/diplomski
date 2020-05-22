public class Tester {
public static void main(String[] args) {

    //gets a session, assuming your cg file is in a folder called hibernate_dispatcher 
    //under classpath
    SessionFactory sessionFactory = new Configuration().configure("/hibernate_dispatcher/hibernate.cfg.xml")
                                 .buildSessionFactory();
    Session session = sessionFactory.openSession();
    //gets a session, assuming your cg file is in a folder called hibernate_dispatcher 
    //under classpath


    //YOUR own query --> gets all products order by count in supplier
    Criteria criteria1 = session.createCriteria(Product.class);
    criteria1.createAlias("supplierId", "supp");
    criteria1.addOrder(Order.desc("supp.count"));

    for(Object p:criteria1.list()){
        Product nthP=(Product)p;
        System.out.println(nthP);
    }
    //YOUR own query --> gets all products order by count in supplier



    //the query you've asked --> gets all products order by price in Product
    Criteria criteria2 = session.createCriteria(Supplier.class);
    criteria2.createAlias("products", "prod");
    criteria2.addOrder(Order.desc("prod.price"));

    for(Object s:criteria2.list()){
        Supplier nthS=(Supplier)s;
        System.out.println(nthS);
    }
    //the query you've asked --> gets all products order by price in Product
}