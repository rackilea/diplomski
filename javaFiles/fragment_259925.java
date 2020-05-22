Questions.add(new QuestionDetails("Which Prime Minister of England was from Huddersfield?","Winston Churchill","Tony Blair","Harold Macmillon"));
Questions.add(new QuestionDetails("Who was the Prime Minister of England in 1940?","John Kennedy","Harold Wilson","Harold Macmillon")); 
Questions.add(new QuestionDetails("Where did Bruce Lee open his first Martial Arts School?","Baltimore","Hong Kong","Hollywood"));}

public QuestionDetails generateResponse(){   Random r = new Random();
int index = r.nextInt(Questions.size());
return Questions.get(index);}