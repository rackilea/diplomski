Queue<String> queue = new LinkedList<String>();
String strLine;
while ((strLine = brtemp.readLine()) != null {
    queue.add(strLine);
    if (strLine.equals("STATEMENT OF ACCOUNT")) {
        queue.clear();
        continue;
    }

    while (queue.size() >= 10) {
        bw.write(queue.remove());
        bw.newLine();
    }
}
while (!queue.isEmpty()) {
    bw.write(queue.remove());
    bw.newLine();
}
bw.flush();