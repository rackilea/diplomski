public void setNameOfAllEntities(final String newname){

    final int changes =
        entityManager.createQuery("update MyEntity set name = :name")
            .setParameter("name", newname)
            .executeUpdate();

    System.out.println(changes + " rows changed");

}