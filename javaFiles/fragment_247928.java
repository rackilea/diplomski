/* Close all the writers */
for(PrintWriter writer : writers) {
    try {
        writer.close();
    } catch(Exception e) {}
}