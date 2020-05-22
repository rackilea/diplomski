public static char[][] readFile() {
    char[][] firstDimension = null;
    try {
        List<String> list = new ArrayList<String>();

        String thisLine = null;
        BufferedReader br;
        br = new BufferedReader(new FileReader("map.txt"));

        while ((thisLine = br.readLine()) != null) {
            list.add(thisLine);
        }

        firstDimension = new char[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            firstDimension[i] = list.get(i).toCharArray();
        }

        for (int i=0; i < firstDimension.length; i++) {
            for (int j=0; j < firstDimension[i].length; j++) {
                System.out.print(firstDimension[i][j]);
            }
            System.out.println();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return firstDimension;
}