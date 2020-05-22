int[] answers = new int[4];
answers[0] = getRandomAnswer();
answers[1] = getRandomAnswer();
answers[2] = getRandomAnswer();
answers[3] = getRandomAnswer();

int correctIndex = Random.nextInt(0,4); // Maybe off by 1? I didn't compile
answers[correctIndex] = correctAnswer;