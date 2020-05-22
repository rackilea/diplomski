import java.util.ArrayList;
import java.util.List;

public class Group {
    String group[];

    public Group(int groupSize) {
        this.group = new String[groupSize];
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < group.length; i++) {

            if (i != 0)
                strBuilder.append(", ");

            strBuilder.append(group[i]);
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        String[] inputArray = { "Hilde Frankum", "Earlie Uphoff",
                "Rich Laclair", "Vicenta Baskin", "Herminia Lakin",
                "Hermelinda Hostetter", "Bernice Sylva", "Blossom Nesby",
                "Lashon Kwan", "Esther Farraj", "Tana Olguin", "Pamula Davin" };

        int numGroups = 4;

        createGroup(inputArray, numGroups);
    }

    public static void createGroup(String inputArray[], int numGroups) {

        int groupSize = inputArray.length / numGroups;

        List<Group> lists = new ArrayList<Group>();

        for (int i = 0; i < numGroups; i++)
            lists.add(new Group(groupSize));

        for (int i = 0, x = 0; i < groupSize; i++)
            for (int j = 0; j < numGroups; j++)
                lists.get(j).group[i] = inputArray[x++];

        for (Group groups : lists)
            System.out.println(groups.toString());
    }
}