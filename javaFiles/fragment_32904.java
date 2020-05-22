int index = random.nextInt(verben.length);
    System.out.println("Please enter correct form of verb!");
    System.out.println(verben[index]);
    String enter = Input.readLine();

    if(enter.equals(verbenAnswer[index])) {
        answer = true;
        points += 1;
    }