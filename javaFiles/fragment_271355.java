List<Integer> numbers = new ArrayList<Integer>();

int n = 100;
for (int i=0; i<n; i++) {
  numbers.add(i);
}
//The array is now 1, 2, 3, ..., 99, 100. Critically, it is sorted.

List<Integer> disordered = new ArrayList<Integer>();
for (int i=0; i<n; i++) {
  if (Math.random() < 0.05) {
    // 5% chance of taking a number from numbers and adding it to disordered
    numbers.remove(i);
    disordered.add(i);
  }
}

while (!disordered.isEmpty()) {
  int x = disordered.remove(0); // Pick a number from disordered
  int position = Math.random()*numbers.size(); // Generate a random number in the domain of numbers
  numbers.add(position, x);
}