@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name="birth_date")
@NotNull
private LocalDate birthDate;`   

public LocalDate getBirthDate() {
    return this.birthDate;
}

public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
}`