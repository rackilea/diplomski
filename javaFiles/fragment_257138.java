public class Queen extends Bee{

    int type = 1;
-->    Hive hive = null;
    public Queen(Hive h){
   -->         hive = h;
        }

    public Queen(int type, int age, int health){
        super(type, age, health);
    }

    public Bee anotherDay(){
        return this;
    }

        public boolean eat(){
   -->         if(hive.honey > 2){
                hive.takeHoney(2); 
                return true;
            }else{
                return false;
            }   
        }
}