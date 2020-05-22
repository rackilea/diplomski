while (!numberCorrect) {
    line = br.readLine();
    try {
        number = Integer.parseInt(line);
    } catch (NumberFormatException ignored) {
        continue;
    }

    // etc
}