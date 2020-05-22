for (HTTPThread t : list) {
    t.start();
}
for (HTTPThread t : list) {
    t.join();
}