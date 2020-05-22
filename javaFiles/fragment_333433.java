public class SitesList {

/** Variables */
private ArrayList<String> name = new ArrayList<String>();
private ArrayList<String> lastName = new ArrayList<String>();

/** In Setter method default it will return arraylist
* change that to add */

public ArrayList<String> getName() {
return name;
}

public void setName(String name) {
this.name.add(name);
}

public void setLastName(String lastName) {
    this.lastName.add(lastName);
}

public ArrayList<String> getLastName() {
    return lastName;
}

}