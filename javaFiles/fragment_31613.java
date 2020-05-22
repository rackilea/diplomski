Map<String,Integer> element = getAllElement();

String baseElem = "{\"index\":{}}\r\n{\"name\":\"$name$\",\"age\":$age$}";

String result = element.entrySet().stream()
    .map(e -> baseElem.replace("$name$", e.getKey())
                      .replace("$age$",  e.getValue().toString()))
    .collect(Collectors.joining());