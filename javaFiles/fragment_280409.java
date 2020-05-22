@PostMapping
  public Activity create(@RequestBody Activity input) {
      if(input.getTags() != null) {
          //you are saving all the nested tags manually before saving the activity
          for(Tag t : input.getTags()) {
              tagRepository.save(t);
          }
      }
      //now you are saving activity which contains these tags
      return activityRepository.save(input);
  }