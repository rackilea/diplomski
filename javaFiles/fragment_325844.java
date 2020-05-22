System.out.println("Which student would you like to delete?");
for (int i = 0; i < 10; i++) {
  if (studentNamesArray[i] != null) {
    studentFound = true;
    System.out.println(i + ": " + studentNamesArray[i]);
  }
}
int studentChoice = input.nextInt();