Map<User, Integer> bestMatches = new HashMap<>();

void validateUser(User user, int value) {
  if(bestMatches.size() < 3) {
     bestMatches.put(User, 3);
     return;
  }

  Map<User, Integer> newMap = new HashMap<User, Integer>();
  User minValue = Collections.min(bestMatches.values());
  if(value > minValue) {
     for(Map.Entry<User, Integer> entry: bestMatches.entrySet()) {
           if(entry.getValue() != minValue) {
              newMap.put(entry.getKey(), entry.getValue());
           }
     }
     newMap.put(user, value);
  }

  bestMatches = newMap;
}