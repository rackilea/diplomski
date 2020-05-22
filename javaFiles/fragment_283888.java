@Transactional
public Set<Sample> getSamplesForLearningEntry(LearningEntry le) {
    // Reload the le from the database so it is not transient:
    LearningEntry le = leDAO.store(le);
    le.getSamples.size();
    return le.getSamples();      
}