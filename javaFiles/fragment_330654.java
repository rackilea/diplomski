public void printVertices(PrintWriter os) {
    for(int i = 0; i < vert.size(); i++) {
        os.print(vert.get(i) + " ");
    }
    os.flush();
}