public class Person {

 private String ownerName;
 private List <Pet> pets = null;

 public String getOwnerName() {
  return ownerName;
 }

 public void setOwnerName(String ownerName) {
  this.ownerName = ownerName;
 }

 public List < Pet > getPets() {
  return pets;
 }

 public void setPets(List < Pet > pets) {
  this.pets = pets;
 }

}

public class Pet {

 private String name;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }
}