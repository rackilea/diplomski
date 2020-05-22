for (int i = 0; i < intVal.length; i++) {
  try {
    numbers[i] = Integer.parseInt(intVal[i]);
    count++;
  }
  catch (NumberFormatException ex) {
    System.out.println(i + " is not a number. Ignoring this value..."); // Or do something else
  }
}