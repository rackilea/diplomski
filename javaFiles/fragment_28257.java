boolean areSubsets(File f1, File f2) throws IOException {
    String[] p = f1.getCanonicalPath().split("/");
    String[] q = f2.getCanonicalPath().split("/");
    for (int i = 0; i < p.length && i < q.length; i++)
        if (!p[i].equals(q[i]))
            return false;
    return true;
}