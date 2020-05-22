public List<Car> searchCars(String makePattern, Set<Security> requiredSecuirtySet) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Car> cq = cb.createQuery(Car.class);
        Root<Car> car = cq.from(Car.class);

        Predicate criteria = cb.conjunction();
        for (Security security : carQueryData.getSecurityCriteria()) {
            criteria = cb.and(criteria, car.get(Car_.securityList).in(security) );
        }
        // Add more predicates, for instance:
        // for (Equipment equipment : carQueryData.getEquipmentsCriteria()) {
        //    criteria = cb.and(criteria, car.get(Car_.equipmentList).in(equipment) );
        // }

        Predicate makePredicate = cb.equal(car.get(Car_.make), makePattern);

        cq.select(car).where(makePredicate, criteria);

        return em.createQuery(cq).getResultList();
    }