try (PrintWriter pw = new PrintWriter(new File("storyFile"));) {
        for (String line : storyArrayList) {
            if (line.equals("#")) {
                pw.append(noun);
            } else if (line.equals("%")) {
                pw.append(verb);
            } else {
                pw.append(line);
            }

            pw.write(System.lineSeparator());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }