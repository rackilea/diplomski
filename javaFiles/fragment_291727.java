public void CalculateFirst(Long id){
    SurveyData survey = surveyDataRepository.findOne(id);
    Integer c=survey.getA()+survey.getB();
    SurveyDataResults  surveyResults = survey.getSurveyresults();
    if (surveyResults == null) {
        surveyResults = new SurveyDataResults();
        surveyResults.setSurvey(survey); //not present in your code but I assume it exists
    }
    surveyResults.setC(c);
    surveyServiceResults.saveSurveyResults(surveyresults);
}