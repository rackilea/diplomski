while (true) {
    int i = new Random().nextInt(prompts.length);
    System.out.println(prompts[i]);
    String input = Raybot.getInput();

    if (!checkPunc(input) && !checkCaps(input)) {
        System.out.println("Check your capitalization and your punctuation!");
    }
    else {
        System.out.println("Great grammar keep it up! Do you want to try again?");  
        input = Raybot.getInput();
        if (input.equals("no")) {
            break;
        }
    }
}

// whatever this does, you intended for it happen after the loop terminates, so do it here
Raybot.talkForever();