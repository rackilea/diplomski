public class DataStructure {

    private Listing[] data;

    private int next = 0;

    DataStructure(int numberofListings) {
        data = new Listing[numberofListings];
        next = 0;
    }


    public void addListing(Listing newListing) {
        if (next < data.length) {
            data[next] = newListing;
            next++;
        }else{                                                         // facultative
            System.out.println("Invalid operation -> array is full");  // it is
        }                                                              // juste informative
    }

    public void showAllListing() {
        for (int i = 0; i < next; i++) {   //print only not empty boxes, stop to 'next'
            System.out.println(data[i]);
        }
    }    

    public static void main(String[] args) {
        DataStructure obj1 = new DataStructure(100);

        Listing l1 = new Listing();
        obj1.addListing(l1);             //next = 0; set item to 0 positon, then next = 1
        obj1.addListing(new Listing());  //next = 1; set item to 1 positon, then next = 2

        obj1.showAllListing();
    }
}