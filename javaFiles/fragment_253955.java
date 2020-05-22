Chunk before = new Chunk("Before ");
Chunk c = new Chunk("www.google.com");
Chunk after = new Chunk(" After");
// create link annotation for c
Paragraph p = new Paragraph();
p.add(before);
p.add(c);
p.add(after);