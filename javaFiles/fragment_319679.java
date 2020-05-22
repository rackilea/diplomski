while (true) {
    try {
        Member member = (Member) os.readObject();
        // Do something with the object
    } catch (EOFException e) {
        break; // Break when the end-of-file is reached
    }
}
os.close();