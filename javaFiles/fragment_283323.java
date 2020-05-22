import java.util.Random;

public class SalaryColumns {

    public static void main(String[] args) {

        int people = 20;
        int month = 12;

        String monthLabel = "Month #";
        String personLabel = "Person #";

        Random r = new Random(System.currentTimeMillis());
        int[][] table = new int[people][month];

        int[] columWidths = new int[month + 1];
        columWidths[0] = personLabel.length() + Integer.toString(people).length() + 1;
        // Load the table with values
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = r.nextInt(20000 - 1000) + 1000;
                columWidths[j + 1] = Math.max(
                        columWidths[j + 1],
                        Math.max(
                                monthLabel.length() + Integer.toString(month).length() + 1,
                                Integer.toString(table[i][j]).length() + 2));
            }
        }

        // Print the table
        System.out.println("\n\nSummer Internship Salary Information:");
        StringBuilder sb = new StringBuilder(128);
        sb.append(String.format("%-" + columWidths[0] + "s", ""));
        for (int i = 0; i < month; i++) {
            String label = monthLabel + i;
            sb.append(String.format("%-" + columWidths[i + 1] + "s", label));
        }
        System.out.println(sb);

        for (int i = 0; i < table.length; i++) {
            sb = new StringBuilder(128);
            String label = personLabel + i;
            sb.append(String.format("%-" + columWidths[0] + "s", label, i));
            for (int j = 0; j < table[i].length; j++) {
                label = String.format("$%d", table[i][j]);
                sb.append(String.format("%-" + columWidths[j + 1] + "s", label));
            }
            System.out.println(sb);
        }
    }
}