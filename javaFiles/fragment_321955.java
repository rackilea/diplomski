public class Main {

    public static void main(String[] args) {
    // Create some actresses
        Actor actress1= new Actor(1,221114445, "Tracy",5.1);
        Actor actress2= new Actor(2,332555412, "Ann", 6.0);
        Actor actress3= new Actor(3,200011458, "Rebecca", 5.8);
        Actor actress4= new Actor(4,701221496, "Marcy", 5.3);

        //Calculate maximum and minimum heights
        double maxHeight = Math.max(Math.max(actress1.height, actress2.height),
                Math.max(actress3.height, actress4.height));
        double minHeight = Math.min(Math.min(actress1.height, actress2.height),
                Math.min(actress3.height, actress4.height));

        //Determine the tallest
        if (maxHeight==actress1.height) {
            System.out.println("Actress "+actress1.name +" "
                    + "is the tallest with a height of : "+actress1.height);
        }
        if (maxHeight==actress2.height) {
            System.out.println("Actress "+actress2.name +" "
                    + "is the tallest with a height of : "+actress2.height);
        }

        if (maxHeight==actress3.height) {
            System.out.println("Actress "+actress3.name +" "
                    + "is the tallest with a height of : "+actress3.height);
        }

        if (maxHeight==actress4.height) {
            System.out.println("Actress "+actress4.name +" "
                    + "is the tallest with a height of : "+actress4.height);
        }

        //Determine the shortest
                if (minHeight==actress1.height) {
                    System.out.println("Actress "+actress1.name +" "
                            + "is the shortest with a height of : "+actress1.height);
                }
                if (minHeight==actress2.height) {
                    System.out.println("Actress "+actress2.name +" "
                            + "is the shortest with a height of : "+actress2.height);
                }

                if (minHeight==actress3.height) {
                    System.out.println("Actress "+actress3.name +" "
                            + "is the shortest with a height of : "+actress3.height);
                }

                if (minHeight==actress4.height) {
                    System.out.println("Actress "+actress4.name +" "
                            + "is the shortest with a height of : "+actress4.height);
                }

    }
}