public static void main(String[] args){
        Car[] cars=new Car[3];
        cars[0]=new Car("Audi","ModelName");
        cars[1]=new Car("BMW","ModelName");
        cars[2]=new Car("Honda","ModelName");

        Scanner scan=new Scanner(System.in);
        System.out.println("Select index to print, should be between 0 and " + (cars.length-1));

        //checks that user actually inputs an integer, 
        //checking its in range is left as an excercise
        while (scan.hasNextInt()==false){
            scan.next(); //consume bad input
            System.out.println("Select index to print, should be between 0 and " + (cars.length-1));

        }
        int index=scan.nextInt();

        System.out.println(cars[index]);


    }