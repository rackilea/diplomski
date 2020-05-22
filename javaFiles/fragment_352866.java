class Food {};

class Bread extends Food {};

class FoodFactory {
    public static Food get(String type){
        switch(type){
            case "bread" : return new Bread();
            default : return new Food();
        }     
    }
}