while ((zeile =  input.readLine()) != null) {
    System.out.println(zeile);
    System.out.println(lineCount);
    lines.add(zeile); // using List#add()
    lineCount++;
}