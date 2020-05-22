public List<Car> findAllByCarChassis(String chassis) {
      String jpql = "select c from Car c where c.carChassis = :chassisParam";

      Query query = entityManager.createQuery(jpql);
      query.setParameter("chassisParam", chassis);

      return query.getResultList();
}