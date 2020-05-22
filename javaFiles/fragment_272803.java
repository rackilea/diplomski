String title = ...;
        final List result = em.createQuery("select b, count(c) from Book b" +
                " join b.copyList c " +
                " where b.title like :title and c.available " +
                " group by b ")
                .setParameter("title", title)
                .getResultList();
        for (Object res : result) {
            Object[]  row = (Object[]) res;
            System.out.println("Book: " + row[0]);
            System.out.println("BookCopy CNT: " + row[1]);
        }