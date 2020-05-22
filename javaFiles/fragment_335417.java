package com.foo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;
import org.springframework.util.AutoPopulatingList;

public class ValidatorTest {

    class Person {
        @NotEmpty
        private String name;

        @NotEmpty
        @Valid
        private List<Foo> list = new AutoPopulatingList<Foo>(Foo.class);

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Foo> getList() {
            return list;
        }

        public void setList(List<Foo> foos) {
            this.list = foos;
        }
    }

    class Foo {
        @NotEmpty
        private String bar;

        public void setBar(String bar) {
            this.bar = bar;
        }

        public String getBar() {
            return bar;
        }
    }

    @Test
    public void testValidator() throws Exception {
        Foo foo0 = new Foo();
        foo0.setBar("");

        Foo foo1 = new Foo();
        foo1.setBar("");

        List<Foo> list = new ArrayList<ValidatorTest.Foo>();
        list.add(foo0);
        list.add(foo1);

        Person person = new Person();
        person.setName("Test Person");
        person.setList(list);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation);
        }
    }
}