public List<TrainingPlan> listTrainingPlans() {
    CriteriaQuery<TrainingPlan> criteria = em.getCriteriaBuilder().createQuery(TrainingPlan.class);
    criteria.select(criteria.from(TrainingPlan.class));
    List<TrainingPlan> trainingPlans = em.createQuery(criteria).getResultList();
    return trainingPlans;
}