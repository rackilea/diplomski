Scanner s = new Scanner(System.in);
    System.out.println("Option (1) is a shot of liquor. \nOption (2) is a beer. \n Option (3) is a glass of wine. \n");
    int temp = s.nextInt();

    double alcc;
    double Raw = 0.0;

    if(temp == 1){
        alcc = AlcGrams(42.5,40);
    }
    else if(temp == 2){
            alcc = AlcGrams(340,5);
    }
    else if(temp == 3){
            alcc = AlcGrams(141.7,12);

    }
    else{
        alcc = 0;
    }


    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your weight in pounds(lbs): ");
    double w = sc.nextDouble();


    double weight = w * 453.592;

    Scanner sce = new Scanner(System.in);
    System.out.println("Enter your gender: (1)-Male  (2)-Female");
    int sexId = sce.nextInt();

    if(sexId == 1){
        String sex = "male";
        Raw = RawNumb(weight,sex);
    }
    else if(sexId == 2){
        String sex = "female";
        Raw = RawNumb(weight,sex);
    }

    double bac = (alcc/Raw)*100;


    Scanner nem = new Scanner(System.in);
    System.out.println("When was your last drink? (In hours)");
    double hour = nem.nextDouble();


    double temporar = bac - hour;
    double allc = temporar;
    System.out.println("Your alcohol percentage is: " + allc);