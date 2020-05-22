private static final Comparator<Person> COMPARATOR = 
    Comparator.comparingInt(Person::getPriority) 
              .thenComparing(Person::getRegistrationDate);

@Override
public int compareTo(Person other) {
    return COMPARATOR.compare(this, other);
}