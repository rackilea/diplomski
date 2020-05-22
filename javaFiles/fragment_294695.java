Person mockPerson = mock(Person.class);
when(mockPerson.getName()).thenReturn(name);
when(mockPerson.getAge()).thenReturn(age);
objectMapper.addMixInAnnotations(Person.class, PersonMixin.class);
try {
    System.out.println(objectMapper.writeValueAsString(mockPerson));
} catch (JsonProcessingException e) {
    e.printStackTrace();
    System.err.println("Failed to serialize mock object.");
}