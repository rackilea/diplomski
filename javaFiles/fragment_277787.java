Integer[] question = new Integer[25];
for (int i = 0; i < question.length; i++) {
    question[i] = i + 1;
}
System.out.println(Arrays.toString(question));
Collections.shuffle(Arrays.asList(question));
System.out.println(Arrays.toString(question));