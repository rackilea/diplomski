Chunk chunk = new Chunk("Contact information");
chunk.setLocalGoto("contact");  
document.add(new Paragraph(chunk));
document.newPage();
chunk chunk1 = new Chunk("Contact information");
chunk1.setLocalDestination("contact");
Chapter chapter = new Chapter(new Paragraph(chunk1),1);    
chapter.setNumberDepth(0);
document.add(chapter);