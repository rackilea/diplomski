public int questionsMissed() {
    for (int index = 0; index < 20; index++) {
        if (Answers[index] == 0) {
            return index + 1;
        }
    }
  return -1;//If nothing works
}