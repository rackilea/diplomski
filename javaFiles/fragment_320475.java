ProductA productA = session.findProductA(..);

Supplier s2 = new Supplier();
// construct s2

em.merge(s2);

productA.setSupplier(s2);

em.merge(productA); // optional