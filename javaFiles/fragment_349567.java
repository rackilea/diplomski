public String displayFreeEvents() {

  StringBuilder stringBuilder = new StringBuilder();

  for (int i = 0; i < freeEvents.size(); i++) {
    String name = "", type = "";
    name = freeEvents.get(i).getEventName();
    type = freeEvents.get(i).getEventType();
    stringBuilder.append(name+ " " + type); // you can add also the \n character if you wish
  }


  return stringBuilder.toString();