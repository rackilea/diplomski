public TrainingPlan createTrainingPlan() {
    TrainingPlan trainingPlan = new TrainingPlan();
    em.persist(trainingPlan);
    return trainingPlan;
}
public TrainingPlan updateTrainingPlan(TrainingPlan trainingPlan) {
    return em.merge(trainingPlan);
}