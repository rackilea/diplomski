public void CalculateFirst(Long id){
    SurveyData survey = surveyDataRepository.findOne(id);
    Integer c=survey.getA()+survey.getB();
    SurveyDataResults  surveyResults = survey.getSurveyresults();
    if (surveyResults == null) {
        surveyResults = new SurveyDataResults();
        survey.setSurveyDataResults(surveyResults);
    }
    surveyResults.setC(c);
    surveyDataRepository.save(survey);
}