public class Animal {
    private String oddSound;
    private String evenSound;

    protected Animal (String oddSound, String evenSound) {
        this.oddSound = oddSound;
        this.evenSound = evenSound;
    }

    public String speak(String what){
        String speakableString = new String();

        for (int i = 0; i < what.length(); i++) {
            if((((int) what.charAt(i)) & 1) == 1){ 
                speakableString = speakableString.concat(oddSound); 
            }else if ((((int) what.charAt(i)) & 1) == 0){
                speakableString = speakableString.concat(evenSound);
            }
        }
}

public class Dog extends Animal {
    public Dog() {
        super ("uff", "vau");
    }
}