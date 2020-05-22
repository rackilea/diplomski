try {
        Scanner sc = new Scanner(fileEntry);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(s);
        }

        sc.close();
    } catch (Exception e) {
        e.printStackTrace();
}