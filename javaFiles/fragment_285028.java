public void save(Resume resume) {
    for (int i = 0; i < storage.length; i++) {
        if (storage[i] == null) {
            // good result: found an empty slot
            storage[i] = resume;
            size = i + 1;
            return;
        }
        if (storage[i].getUuid().equals(resume.getUuid())) {
            // bad result: found a duplicate
            System.out.println("ERROR: Resume with " + storage[i].getUuid() + " is already exist!");
            return;
        }
    }

    // bad result: storage full
    System.out.println("ERROR: Storage full");
}