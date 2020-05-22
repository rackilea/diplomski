public class Main3 {

    public static void main(String[] args) {

        ArrayList<String> outList = new ArrayList<>();

        final int year = 2018;
        Scanner scan = new Scanner(System.in);
        Path path = Paths.get("zadanie3.txt");
        try {
            for (String line : Files.readAllLines(path)) {
                String[] tab = line.split(" ");
                if (tab[3].equals("m")) {
                    if (year - (Integer.parseInt(tab[2])) >= 65) {
                        outList.add(line);

                    }

                } else if (tab[3].equals("k")) {
                    if (year - (Integer.parseInt(tab[2]) ) >= 60) {
                        outList.add(line);

                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(outList);
    }
}