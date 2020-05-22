public class WeeklyMenu {
private boolean isChecked;
private String timing;
private String monFood;
private String tueFood;
private String wedFood;
private String thuFood;
private String friFood;
private String satFood;
private String sunFood;

public WeeklyMenu(boolean isChecked, String timing, String monFood, String tueFood, String wedFood, String thuFood, String friFood,
        String sutFood, String sunFood) {
    super();
    this.isChecked = isChecked;
    this.timing = timing;
    this.monFood = monFood;
    this.tueFood = tueFood;
    this.wedFood = wedFood;
    this.thuFood = thuFood;
    this.friFood = friFood;
    this.satFood = sutFood;
    this.sunFood = sunFood;
}

public String getTiming() {
    return timing;
}

public void setTiming(String timing) {
    this.timing = timing;
}

public boolean isChecked() {
    return isChecked;
}
public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
}
public String getMonFood() {
    return monFood;
}
public void setMonFood(String monFood) {
    this.monFood = monFood;
}
public String getTueFood() {
    return tueFood;
}
public void setTueFood(String tueFood) {
    this.tueFood = tueFood;
}
public String getWedFood() {
    return wedFood;
}
public void setWedFood(String wedFood) {
    this.wedFood = wedFood;
}
public String getThuFood() {
    return thuFood;
}
public void setThuFood(String thuFood) {
    this.thuFood = thuFood;
}
public String getFriFood() {
    return friFood;
}
public void setFriFood(String friFood) {
    this.friFood = friFood;
}
public String getSatFood() {
    return satFood;
}
public void setSatFood(String sutFood) {
    this.satFood = sutFood;
}
public String getSunFood() {
    return sunFood;
}
public void setSunFood(String sunFood) {
    this.sunFood = sunFood;
}