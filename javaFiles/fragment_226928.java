@PostMapping(value = "/newjob")
  public void addNewJob(
      @ModelAttribute("addNewJob") final JobPostEntity myEntity) {
    System.out.println("got dto: " + myEntity);
    System.out.println("selectCategory: " + myEntity.getSelectedCategory());
  }