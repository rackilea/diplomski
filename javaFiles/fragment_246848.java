public class ChatBot {

  public static void main(String[] args) {
    String[][] animalArray = new String[10][3];

    animalArray[0][0] = "Dogs";
    animalArray[0][1] = "Dawgs";

    animalArray[1][0] = "Cats";
    animalArray[1][1] = "Catds";

    animalArray[2][0] = "Horses";

    animalArray[3][0] = "Lamas";

    animalArray[4][0] = "Ducks";
    animalArray[4][1] = "Duckss";

    animalArray[5][0] = "Pigs";

    animalArray[6][0] = "Cows";

    animalArray[7][0] = "Rabbits";

    animalArray[8][0] = "Chickens";

    animalArray[9][0] = "Mice";


    String response = JOptionPane.showInputDialog("Hi there, theses are all the animals i like to talk about ! :"
            + "\n-Dogs" + "\n-Cats" + "\n-Rabbits" + "\n-Lamas" + "\n-Hores" + "\n-Ducks" + "\n-Pigs" + "\n-Cows"
            + "\n-Chickens" + "\n-Mice" + "\n-Ask me somthing !");

    while (true) {
        for (int i = 0; i < animalArray.length; i++) {
            for (int j = 0; j < animalArray[i].length; j++) {
                if (animalArray[i][j] != null && response.toLowerCase().contains(animalArray[i][j].toLowerCase())) {
                    String animal = animalArray[i][0];
                    response = JOptionPane.showInputDialog(animal + " ? I love " + animal + ", they taste great!\n"
                            + "What other animals do you like ?");
                    break;
                }
            }
        }
    }
}