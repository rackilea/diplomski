public static void main(String[] args) {

        Velocity v1 = new Velocity(14, 14, 14);
        Velocity v2 = new Velocity(14, 14, 14);
        Velocity result = v1.sum(v2);
        System.out.println(result);
    }

}