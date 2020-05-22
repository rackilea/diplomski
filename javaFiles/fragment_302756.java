import static fj.test.Arbitrary.*;
import static fj.Function.*;

static final Arbitrary<Person> personArbitrary =
  arbitrary(arbInteger.gen.bind(arbString.gen, arbBoolean.gen,
      curry(new F3<Integer, String, Boolean, Person>() {
        public Person f(final Integer age, final String name, final Boolean male)
          {return new Person(age, name, male);}})));