public class Meal {

//I dont know what type of data each attribute is supposed to be so I chose ints. Feel free to change.
private int mealId;
private int mealCode;
private int mealType;

public Meal(int mealId, int mealCode, int mealType){
    this.mealId = mealId;
    this.mealCode = mealCode;
    this.mealType = mealType;
}

public int getMealId() {
    return mealId;
}

public int getMealCode() {
    return mealCode;
}

public int getMealType() {
    return mealType;
}
}