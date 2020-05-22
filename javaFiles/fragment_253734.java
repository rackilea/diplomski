@Test
public void removeFiles() {
    Files files = (Files) session.get(Files.class, 1L);

    session.delete(files);
    session.flush();

    Query q = session.createQuery("from Files f where f.id = :id");
    q.setParameter("id", 1l);
    Files result = (Files) q.uniqueResult();
    assertNull(result);
}