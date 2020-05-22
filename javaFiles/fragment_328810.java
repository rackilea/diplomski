try (Scanner scanner = new Scanner(new File(fileName))) {
     while (scanner.hasNext()) {
        particularItems.add(processLine(line));
     }

} catch (FileNotFoundException e) {
   e.printStackTrace();
}