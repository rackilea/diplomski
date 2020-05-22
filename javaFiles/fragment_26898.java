//Filter PersonAddDetail to have just the types needed
DataStream<PersonContainer> filteredPersonAddDetail = unfilteredPersonAddDetail.filter(new FilterFunction<OboTtrDetailAddEvent>() {
      @Override
      public boolean filter(PersonAddDetail personAddDetail) throws Exception {
        return personAddDetail.getAddDetailType().matches("1|2");
      }
    });

//map Person stream to common object
DataStream<PersonContainer> mappedPersonStream = personInputStream.map(new MapFunction<Person, PersonContainer>() {
  @Override
  public PersonContainer map(Person Person) throws Exception {
    return new PersonContainer(Person);
  }
});

//map PersonDetail stream to common object
DataStream<PersonContainer> mappedPersonDetailStream = personDetailInputStream.map(new MapFunction<PersonDetail, PersonContainer>() {
  @Override
  public PersonContainer map(PersonDetail PersonDetail) throws Exception {
    return new PersonContainer(PersonDetail);
  }
});

//map PersonAddDetail stream to common object
DataStream<PersonContainer> mappedPersonAddDetailStream = filteredPersonAddDetail.map(new MapFunction<PersonAddDetail, PersonContainer>() {
  @Override
  public PersonContainer map(PersonAddDetail PersonAddDetail) throws Exception {
    return new PersonContainer(PersonAddDetail);
  }
});

//union the three input streams to one single stream
DataStream<PersonContainer> combinedInput = mappedPersonStream.union(mappedPersonDetailStream, mappedPersonAddDetailStream);

// Iteration pattern is in place here and I'm going to recursively try to merge corresponding objects togehter
IterativeStream<PersonContainer> iteration = combinedInput.iterate();

// Group objects by there shared ID and then use reduce to merge them
DataStream<PersonContainer> iterationBody = iteration.keyBy(new KeySelector<PersonContainer, String>() {
  @Override
  public String getKey(PersonContainer personContainer) throws Exception {
    return personContainer.getId();
  }
})
    .reduce(new ReduceFunction<PersonContainer>() {
      @Override
      public PersonContainer reduce(PersonContainer personContainer, PersonContainer other) throws Exception {
        return personContainer.merge(other);
      }
    });

// use the containers complete method to check whether the merge is finished or we need to wait for further objects in the stream   
DataStream<PersonContainer> containersNotCompleteYet = iterationBody.filter(new FilterFunction<PersonContainer>() {
  @Override
  public boolean filter(PersonContainer PersonContainer) throws Exception {
    return !personContainer.isComplete();
  }
});

// partially merged or not merged at all containers are put back on the stream
iteration.closeWith(containersNotCompleteYet);

// fully merged containers are processed further
DataStream<PersonContainer> completeContainers = iterationBody.filter(new FilterFunction<PersonContainer>() {
  @Override
  public boolean filter(PersonContainer PersonContainer) throws Exception {
    return personContainer.isComplete();
  }
});

// finally the container is mapped to the correct output object
DataStream<PersonReport> personReport = completeContainers.map(new MapFunction<PersonContainer, PersonReport>() {
  @Override
  public PersonReport map(PersonContainer personContainer) throws Exception {

    // map personContainer to final PersonReport

    return personContainer;
  }
});