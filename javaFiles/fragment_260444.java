public class BraveKnight {
    private Quest quest;
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }
}

public class Quest {

}

public class Main {
    public static void main (String[] args) {
        Quest quest = new Quest();
        BraveKnight knight = new BraveKnight(quest);
    }
}