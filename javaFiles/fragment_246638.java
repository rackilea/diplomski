private static StringBuilder appendStrings(String pro, List<ProcConfig> list, StringBuilder sb) {
    Formatter formatter = new Formatter(sb);
    String template ="";
    for (ProcConfig pc : list) {
        if (pro.length() == 6)
            template = "%-6s %d %3d %-15s %d %d %s %n";
        else if (pro.length() > 35)
            template = "%-53s %d %3d %-15s %d %d %s %n";
        else
            template = "%-35s %d %3d %-15s %d %d %s %n";
        formatter.format(template, pro, pc.getNo(), pc.getId(), pc.getAddress(), pc.getPort(), pc.getNumPorts(), pc.getName());
    }
    formatter.close();
    return sb;
}