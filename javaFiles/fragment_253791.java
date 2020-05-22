try {
        Demand demandToUpdate = entityManager.merge(demand);
        entityManager.flush();
    } catch (PersistenceException e) {
        throw new DemandExceptions("Update Error: " + e.getMessage());
    }