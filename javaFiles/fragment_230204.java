while (tree.hasNext()) {
    Person p = tree.next();
    String content = p.toString();
    System.out.println(p);
    bw.write(content);
    bw.close();
}