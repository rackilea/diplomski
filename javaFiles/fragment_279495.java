int[] numbersA = new int[5];
int[] numbersB = new int[5];
for (int i = 0; i < numbersA.length; i++) {
    out.print("Please insert a number for the first array: ");
    numbersA[i] = Integer.parseInt(in.readLine());
}

for (int i = 0; i < numbersB.length; i++) {
    out.print("Please insert a number for the second array: ");
    numbersB[i] = Integer.parseInt(in.readLine());
}
int[] numbersC = new int[Math.min(numbersA.length, numbersB.length)];
out.print("The sum of the two arrays are: ");
for (int i = 0; i < numbersC.length; i++) {
    numbersC[i] = numbersA[i] + numbersB[i];
    out.print(numbersC[i] + " ");
}
out.println();