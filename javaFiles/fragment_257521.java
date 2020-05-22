assertThat(
  people,
  contains(
    sameBeanAs(expectedPerson).with("address.streetName", startsWith("Via")
  )
);