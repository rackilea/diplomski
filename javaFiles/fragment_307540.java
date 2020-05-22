public class TestDate {

    public static void main (String ...args) {
            Date dateOne = new Date();
            long dateOneTime = dateOne.getTime();
            long dateTwoTime = dateOneTime/1000;

            System.out.println(dateOneTime);
            System.out.println(dateTwoTime);

            long dateThreeTime = dateTwoTime*1000;

            dateTwoTime *= 1000;

            System.out.println(dateThreeTime);
            System.out.println(dateTwoTime);
            Date dateTwo = new Date(dateTwoTime);
            if(dateOne.equals(dateTwo)) {
                    System.out.println("Dates are equal");
            } else {
                    System.out.println("Dates are not equal");
            }
    }

}