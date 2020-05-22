task = new Task<>() {
    public Integer call() {
        int lines = 0;

        Collection<String> linesBuffer = new ArrayList<>(100_000);
        long timeOfLastAppend = System.nanoTime();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesBuffer.add(line);

                // Do not update the TextArea more than 10 times per second
                // (that is, every 100 million nanoseconds).
                long time = System.nanoTime();
                if (time - timeOfLastAppend >= 100_000_000L) {
                    timeOfLastAppend = time;

                    String text = String.join(" \n", linesBuffer) + " \n";
                    Platform.runLater(() -> textArea.appendText(text));

                    linesBuffer.clear();
                }

                lines++;
                updateMessage(lines + " lines read.");
            }

            if (!linesBuffer.isEmpty()) {
                String text = String.join(" \n", linesBuffer) + " \n";
                Platform.runLater(() -> textArea.appendText(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
};