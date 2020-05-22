public class LoadAnotherClass {

    public static void main(String[] args) {
        new FileDataService().loadData();
        // or even
        FileDataService.main(new String[]{});
    }

}