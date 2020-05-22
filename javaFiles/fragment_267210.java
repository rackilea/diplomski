public class Cat {
private Long id; // identifier

private Date birthdate;
private Color color;
private char sex;
private float weight;
private int litterId;

private Cat mother;
private Set kittens = new HashSet();

private void setId(Long id) {
    this.id=id;
}
public Long getId() {
    return id;
}

void setBirthdate(Date date) {
    birthdate = date;
}
public Date getBirthdate() {
    return birthdate;
}

void setWeight(float weight) {
    this.weight = weight;
}
public float getWeight() {
    return weight;
}

public Color getColor() {
    return color;
}
void setColor(Color color) {
    this.color = color;
}

void setSex(char sex) {
    this.sex=sex;
}
public char getSex() {
    return sex;
}

void setLitterId(int id) {
    this.litterId = id;
}
public int getLitterId() {
    return litterId;
}

void setMother(Cat mother) {
    this.mother = mother;
}
public Cat getMother() {
    return mother;
}
void setKittens(Set kittens) {
    this.kittens = kittens;
}
public Set getKittens() {
    return kittens;
}

// addKitten not needed by Hibernate
public void addKitten(Cat kitten) {
    kitten.setMother(this);
kitten.setLitterId( kittens.size() ); 
    kittens.add(kitten);
}