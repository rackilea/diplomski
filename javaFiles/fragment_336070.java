import java.util.Observable;

    public class Keybaord extends Observable {

        private String keyThatIsPressed;

        public void setKeyThatIsPressed(String keyThatIsPressed) {
            this.keyThatIsPressed = keyThatIsPressed;
            setChanged();
            notifyObservers(keyThatIsPressed);
        }

        public String getKeyThatIsPressed(){
            return keyThatIsPressed;
        }

 }