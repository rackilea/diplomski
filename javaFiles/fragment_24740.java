String[][] arrayA = new String[lineNum][];
String[][[ arrayB = new String[lineNum][];

int counterA = 0;
int counterB = 0;

while (scannerIn.hasNextLine()) {
    String line = scannerIn.nextLine();
    String[] parts = line.split("\\s");
    if (line.startsWith("2014")) {
        arrayA[counterA++] = parts;
    } else if (line.startsWith("2015")) {
        arrayB[counterB++] = parts;
    }
}

// prune excess elements
arrayA = Arrays.copyOf(arrayA, counterA);
arrayB = Arrays.copyOf(arrayB, counterB);