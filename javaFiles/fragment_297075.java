public class UserForm {
String name,birthday,hobby;
boolean isPassedInspection;

public UserForm(String name, String birthday, String hobby, boolean isPassedInspection) {
    this.name = name;
    this.birthday = birthday;
    this.hobby = hobby;
    this.isPassedInspection = isPassedInspection;
}

public UserForm() {
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getBirthday() {
    return birthday;
}

public void setBirthday(String birthday) {
    this.birthday = birthday;
}

public String getHobby() {
    return hobby;
}

public void setHobby(String hobby) {
    this.hobby = hobby;
}

public boolean isPassedInspection() {
    return isPassedInspection;
}

public void setPassedInspection(boolean passedInspection) {
    isPassedInspection = passedInspection;
}}