public static void main(String[] args) {


        double left = Math.random();

        System.out.println("left : "+left);

        double right =  Math.random();

        System.out.println("right : "+right);

        System.out.println(pickOne(left, right));
    }

    public static double pickOne(double left, double right) {
        return Math.random() < Math.random() ? left : right;
    }