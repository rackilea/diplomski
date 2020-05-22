Random rand = new Random();
Collections.shuffle(list);

int ques = 0;
while (runThrough == 0 && ques < 50) {
    System.out.print("What's the capital of " + list.get(ques).getName()
        + "? (STOP to quit) ");

    // Your other stuff remains as is, just update
    // list.get(ques).getCapital()
    //           ^^

    ++ques;
}