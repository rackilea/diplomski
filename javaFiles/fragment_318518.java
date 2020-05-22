class TeamInfo {
    private Scanner nScan = new Scanner(System.in);
    private String name;

    public void promptName() {
        name = nScan.nextLine();
    }

    public String getName() {
        return name;
    }
}