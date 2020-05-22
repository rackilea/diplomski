private String printPath(Vertex destiny, String concat) {
    if (destiny.getPrevious() == null) {
        return " , " + concat;
    } else {
        return printPath(destiny.getPrevious(), (destiny.getName() + " " + concat));
    }
}