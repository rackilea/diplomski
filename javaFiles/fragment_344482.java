Map<PopulationWithState, List<FaqEntry>> faq = new HashMap<>();
//Fetch list of questions for a type. Return a new List if no questions exist
faq.computeIfAbsent(PopulationWithState.MenYoungNotWorking, k-> new LinkedList<>()).add(new FaqEntry("Question here", "Answer here"));
faq.computeIfAbsent(PopulationWithState.MenYoungNotWorking, k-> new LinkedList<>()).add(new FaqEntry("Question 2 here", "Answer 2 here"));

//Fetch a particular list
List<FaqEntry> menYoungNotWorking = faq.computeIfAbsent(PopulationWithState.MenYoungNotWorking, k-> new LinkedList<>());