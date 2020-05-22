public class FileInfo {

private String Name;
private String Adress;
private String Favourite_food;

public FileInfo() {
}

public FileInfo(String Name, String Adress, String Favourite_food) {
    this.Name = Name;
    this.Adress = Adress;
    this.Favourite_food = Favourite_food;
}

public String getName() {
    return Name;
}

public void setName(String Name) {
    this.Name = Name;
}

public String getAdress() {
    return Adress;
}

public void setAdress(String Adress) {
    this.Adress = Adress;
}

public String getFavourite_food() {
    return Favourite_food;
}

public void setFavourite_food(String Favourite_food) {
    this.Favourite_food = Favourite_food;
}

}