public void writeList() {
    try (FileOutputStream inputStream = new FileOutputStream(this.pathOut);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(inputStream);
            PrintWriter out = new PrintWriter(outputStreamWriter)) {
        // Delegate the way to write the numbers to this new method
        writeNumbers(out);
    } catch (final ArrayIndexOutOfBoundsException e) {
        ListOfNumbers.LOGGER.error(
            "Caught ArrayIndexOutOfBoundsException: " + e.getMessage(), e
        );
    } catch (final FileNotFoundException e) {
        ListOfNumbers.LOGGER.error("Caught FileNotFoundException: " + e.getMessage(), e);
    } catch (final IOException e) {
        ListOfNumbers.LOGGER.error("Caught IOException: " + e.getMessage(), e);
    }
}

/**
 * The new method that is protected here but could also be package protected
 * but cannot be private to be able to override it.
 */
protected void writeNumbers(PrintWriter out) {
    for (int i = 0; i < this.numbers.size(); i++) {
        out.println("Value at: " + i + " = " + this.numbers.get(i));
    }
}