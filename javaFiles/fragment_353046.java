@Override
protected void onClick(DialogInterface dialog, int which) {
    Random generator = new Random(); 
    int number = generator.nextInt(NUMBER_OF_LEVELS) + 1;

    Class activity;

    switch(number) {
        case 1:
            activity = LevelOne.class;
            break;
        case 2:
            activity = LevelTwo.class;
            break;
        case 3:
            activity = LevelThree.class;
            break;
        case 4:
            activity = LevelFour.class;
            break;
        case 5:
            activity = LevelFive.class;
            break;

        ...

        case 20:
            activity = LevelTwenty.class;
            break;
    }

    Intent intent = (getBaseContext(), activity);
    startActivity(intent);
}