package com.entites

public class PersonDto {

    private Person person;

    private Integer countOfNames;

    public PersonDto(Person person, Integer countOfNames) {
        this.person = person;
        this.countOfNames = countOfNames;
    }

}

select new com.entites.PesronDto(a, count(a.name)) 
  from Person a 
  where a.name like :name