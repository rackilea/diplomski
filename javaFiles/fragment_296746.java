/**true if had a ship, false if it was a miss
    */
public class BattleSquare{     
        public boolean processHit(){
             if (hasShip()){
                ship.setState(DESTROYED);
               return true;
             }
            return false;
        }
        public void setShip(Ship ship){ .... }
        public boolean hasShip() { ... } }   ... methods for color too