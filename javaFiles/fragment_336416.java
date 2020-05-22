em.getTransaction().begin();

Library library = new Library(1L, "Central library");
em.persist(library);

em.persist(new Book(1L, "Harry potter", "123-123-123-123", 1000, library));

em.getTransaction().commit();
em.detach(library);   // This did the trick

library = em.find(Library.class, 1L);
System.out.println(library.getBooks());