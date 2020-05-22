public class SummonedBin {

    List<Summon> bin = new ArrayList<Summon>();

    SummonedBin() {

    }

    void addToBin() {
        Summon summoned = new Summon();
        int index = 0;
        while (bin.get(index) != null) {
            index++;
        }
        bin.add(index, summoned); 
    }
}