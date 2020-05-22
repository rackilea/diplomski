@Override
public AssessmentKey update(AssessmentKey assessmentKey) {
    OpenJPAEntityManager openJpaEntityMgr = OpenJPAPersistence.cast(entityManager);
    // there may be your operation
    return entityManager.merge(assessmentKey);
}