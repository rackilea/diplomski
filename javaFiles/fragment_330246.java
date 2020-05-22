public static void main(String[] args) {
    String[][] array = new String[4][2];
    Scanner sc = new Scanner(System.in);
    int totalDownloads = 0;

    for (int i = 0; i < array.length; i++) {
        System.out.println("What is track " + (i + 1));
        array[i][0] = sc.nextLine();
        System.out.println("How many thousands of times has it been downloaded? ");
        int downloads = Integer.parseInt(sc.nextLine()) * 1000;
        array[i][1] = String.valueOf(downloads);
        totalDownloads += downloads;
    }

    sc.close();

    int mostDownloadsIndex = 0;

    for (int i = 1; i < array.length; i++) {
        if (Integer.parseInt(array[i][1]) > Integer.parseInt(array[mostDownloadsIndex][1]))
            mostDownloadsIndex = i;
    }

    System.out.println("The track downloaded the most is " + array[mostDownloadsIndex][0]);
    System.out.println("The total number of downloads of these 4 tracks was " + totalDownloads);
    System.out.println("The details of the downloads are");
    for (int i = 0; i < array.length; i++) {
        System.out.println(Arrays.toString(array[i]));
    }
}