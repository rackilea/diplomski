synchronized (d.reader) {
    try {
        d.reader.wait();
        System.out.println("got notify");
    } catch (Exception e) {
        System.out.println(e);
    }
}