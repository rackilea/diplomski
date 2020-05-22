public products getProductDescription(String Code)
{

    setSessionFactory();
    Session session = factory.getCurrentSession();

    session.beginTransaction();
    String query = "from products p where p.code=:code";
    Query q = session.createQuery(query); //query is already created here
    q.setString("code", Code);
    System.out.println(query);

    //delete the line below
    //products pr  = (products)session.createQuery(q);

    //add the lines below
    List<products> l = (List<products>) q.list();
    products pr = null;
    if(!l.isEmpty()) {
        pr = l.get(0);
    }

    session.close();
    return pr;
}