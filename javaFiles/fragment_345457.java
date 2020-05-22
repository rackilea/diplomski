lineNumber.close();

// REMOVE String line = inputFile.readLine();

Car[] car = new Car[length/3];

// REMOVE while (line != null)
// REMOVE {
for (int i = 0; i < length/3; i ++) // DON'T DO i += 3 because that will make you go beyond the bounds of the car array 
{
    int startReading = Integer.parseInt(inputFile.readLine());
    int endReading = Integer.parseInt(inputFile.readLine());
    int liter = Integer.parseInt(inputFile.readLine());
    car[i] = new Car (startKm, endKm, litre);
}
// REMOVE }