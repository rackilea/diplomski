Map<String, Integer> choice_delta = // new Map

// Define choice delta pairing
choice_delta.put("answer5", -5);
choice_delta.put("answer6", 20);
// etc. etc.

int calculate(String[] answers){
    int result = 0;
    for (String answer : answers){
        int delta = choice_delta.get(answer);
        result += delta;
    }
    return result;
}