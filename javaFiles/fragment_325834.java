public class Main {
    public static void main(String[] args) {
        // Create first element
        Date date1 = new Date(System.currentTimeMillis());
        Video video1 = new Video(date1, "Timelapse");

        // Create second element
        Date date2 = new Date(System.currentTimeMillis() - 1000);
        Photo photo1 = new Photo(date2, "My pretty picture");

        // Create list
        ArrayList<Media> myMedia = new ArrayList<>();
        myMedia.add(video1);
        myMedia.add(photo1);

        // Original
        System.out.println("Original list:");
        printMediaList(myMedia);

        // Sorted
        System.out.println("Sorted list:");
        Media.sort(myMedia);
        printMediaList(myMedia);
    }

    public static void printMediaList(List<Media> myMedia) {
        for (int i = 0; i < myMedia.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, myMedia.get(i).getName());
        }

        System.out.println();
    }

}