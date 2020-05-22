import static org.unitils.reflectionassert.ReflectionAssert.*;

// Exact field-by-field comparison
assertReflectionEquals(new Person("John", "Doe", new Address("New street", 5, "Brussels")), 
                                 new Person("John", "Doe", new Address("New street", 5, "Brussels"));

// Ignore Null / 0 values in the expected object
assertReflectionEquals(new Person("John", null, new Address("New street", 0, null)),
                                 new Person("John", "Doe", new Address("New street", 5, "Brussels"), 
                                 ReflectionComparatorMode.IGNORE_DEFAULTS); 

// Ignore collection order
assertReflectionEquals(Arrays.asList(new Person("John"), new Person("Jane")),
                                 new Person[] {new Person("Jane"), new Person("John")}, 
                                 ReflectionComparatorMode.LENIENT_ORDER);

// Ignore null/0 values + collection order
assertLenientEquals(Arrays.asList(new Person("John"), null),
                                 new Person[] {new Person("Jane", "Doe"), new Person("John", "Doe")});

// Check only the firstName property 
assertPropertyLenientEquals("firstName", Arrays.asList("John", "Jane"),
                                 new Person[] {new Person("Jane", "Doe"), new Person("John", "Doe")});