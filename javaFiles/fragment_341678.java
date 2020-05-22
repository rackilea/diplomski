import java.util.Scanner;

class Player {
    private BaseClass playerClass;

    public void setPlayerClass() {
        Scanner in = new Scanner(System.in);
        StringBuilder output = new StringBuilder("Select a class:\n");
        BaseClass[] classes = BaseClass.values();
        for (int i = 0, len = classes.length; i < len; i++) {
            output.append("\t").append(i + 1).append(": ")
                  .append(classes[i].name()).append("\n");
        }
        output.append(" >> ");
        System.out.print(output.toString());
        int playerChoice = in.nextInt();
        in.close();
        switch (playerChoice) {
            case 1:
                playerClass = BaseClass.Barbarian;
                break;
            case 2:
                playerClass = BaseClass.Cleric;
                break;
            case 3:
                playerClass = BaseClass.Mage;
                break;
            case 4:
                playerClass = BaseClass.Fighter;
                break;
        }
    }

    public BaseClass getPlayerClass() {
        return playerClass;
    }

    public static void main(String[] args) {
        Player p = new Player();
        p.setPlayerClass();
        System.out.println("Player selected: " + p.getPlayerClass().name());
    }
}

enum BaseClass {
    Barbarian, Cleric, Mage, Fighter;
}