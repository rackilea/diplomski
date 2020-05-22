List<Integer> listIntegers = new ArrayList<>();
File f = new File("D:\\generated30-1.cav");
try (Scanner sc = new Scanner(f)) {
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] tokens = line.split("\\s*,\\s*");
        for (String token : tokens) {
            listIntegers.add(Integer.parseInt(token));
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}
return listIntegers;