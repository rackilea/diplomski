public class GamePanel {

    private final Pet pet;

    public GamePanel(PetWorld petWorld, Pet pet, Game game) {
        this.pet = pet;
        initComponents();
        genComponents(); <-- remove the pet parameter
    }

    private void genComponents() {
        ....

        feedBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pet.feedPet();    <-- this pet now refers to the class variable, which is still in scope.
            }
        });

        ....
    }
}