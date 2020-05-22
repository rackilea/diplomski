model.setViewName("question-list");
int id = 0;
try
{
    if(code != null)
      id = Integer.parseInt(code);
}
catch (NumberFormatException e)
{
    id = 0;
}
Question question = em.find(com.databaseproject.questor.model.Question.class, id);