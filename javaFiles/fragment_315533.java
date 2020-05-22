int count;

public void createFolder() {
    File file = new File("C:\\Users\\user\\Desktop\\new\\"" + count);
    if (!file.exists()) {
        if (file.mkdir()) {
            System.out.println("Directory is created!");
            count++;
        }
    } else {
        System.out.println("Failed to create directory!");
        count++;
        createFolder();
    }
}