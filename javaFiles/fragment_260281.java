public static void main(String[] args){
    Animals [] array = new Animals[2];
    array[0] = new Dogs();
    array[1] = new Cats();
    array[0].bark();
}

public static void makeSound(Animal[] animals){
    for(Animal a : animals){
        if(a instanceof Dogs){
            ((Dogs)a).bark();
        }else if(a instanceof Cats){
            ((Cats)a).meow();
        }
}