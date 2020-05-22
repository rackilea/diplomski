} catch (FileNotFoundException e) {
        //e.printStackTrace();
        System.out.println("file not found " + e.getMessage());
    } catch (IOException e) {
        e.printStackTrace();
    }

    List<String> validationFileCopy = Collections.unmodifiableList(validationFile);