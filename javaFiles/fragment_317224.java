List<Task> finalResults = results.stream()
                                 .filter(t->kvVars.entrySet()
                                                  .stream()
                                      .allMatch(k->t.getInputData().containsKey(k.getKey()) 
                                                   && t.getInputData().get(k.getKey()).equals(k.getValue()))
                                 .collect(Collectors.toList());