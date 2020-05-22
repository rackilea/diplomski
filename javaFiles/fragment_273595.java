String productSelect = "select p from Product "
                + "p left join fetch p.suppliers "
                + "where p.productName=:pname";
Query query = session.createQuery(productSelect);
query.setParameter("pname", productname);
Product result = (Product) query.uniqueResult();