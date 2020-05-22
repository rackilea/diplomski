Map<Question, List<Distractor>> questionDistractorMap = getMap();
List<Question> ques = new ArrayList<>(questionDistractorMap.keySet());
Random random = new Random();
while(ques.size() > -1){
  int index = random.nextInt(ques.size());
  System.out.println("Question: " + ques.get(index));
  System.out.println("Distractors:" + questionDistractorMap.get(ques.get(index)));
  ques.remove(index);
}