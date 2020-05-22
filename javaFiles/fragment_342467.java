list = new XmlParser().parseText xml

widgetWithExplanations = list.breadthFirst()
  .findAll { it.buzz.text() == "true" }

masterList = widgetWithExplanations
  .collect { it.explanations.string*.text() }
  .flatten()

assert masterList == [
    "What is the meaning of life?", 
    "I like the color blue.", 
    "I could really go for some pizza right now."]


emptyExplanations = widgetWithExplanations
    .count { !it.explanations.string }

assert emptyExplanations == 0