public List<CandidateFeedbackDisplay> list(Integer cID, Integer jID, String accepted) throws Exception {
    ...
    // DELETE HERE
    // CandidateFeedbackDisplay feedbackDisplay = new CandidateFeedbackDisplay();
    List<CandidateFeedbackDisplay> feedbackDisplayList = new ArrayList();
    try {   
        ...
        while(itr.hasNext()) {
            ...
            // INSERT HERE
            CandidateFeedbackDisplay feedbackDisplay = new CandidateFeedbackDisplay();
            feedbackDisplay.setFeedbackIds(feedbackid);
            feedbackDisplay.setCandidate(candidate);            
            feedbackDisplayList.add(feedbackDisplay);
        }
    } catch (Exception e) {
        ...
    }
    return feedbackDisplayList;
}