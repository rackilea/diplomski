try (FileWriter MainfileWriter = new FileWriter(mainTableCSV, true)) {
            MainfileWriter.append(MAIN_FILE_HEADER.toString());
            MainfileWriter.append(NEW_LINE_SEPARATOR);
            MainfileWriter.append("test");
        } catch (IOException e) {
            e.printStackTrace();
        }