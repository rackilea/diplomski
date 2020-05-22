List<Observation> entries = new ArrayList<>();

    //Create two seperate lists as per your requirement.
    List<Integer> ids = new ArrayList<>();
    List<Boolean> status = new ArrayList<>();
    for(int i=0;i<entries.size();i++){
      Observation observation = entries.get(i);
      ids.add(observation.getId());  //Here get integer from your Observation object
      ids.add(observation.getStatus());  //Here get boolean value from your Observation object.
    }
  }