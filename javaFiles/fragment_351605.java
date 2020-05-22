do {
        readCase = (Person) objectInputStream.readObject();
        if (readCase != null) {
            recordList.add(readCase);
        }
} while (readCase != null);