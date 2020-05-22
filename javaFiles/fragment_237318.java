public class Person {
    private LocalDate birthDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate birthDate) { 
        this.birthDate = birthDate;
    }
}