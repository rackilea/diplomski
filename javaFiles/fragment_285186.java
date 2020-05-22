EpubReader epubReader = new EpubReader();
Book book = epubReader.readEpub(new FileInputStream("mybook.epub"));

// set title
book.getMetadata().setTitles(new ArrayList<String>() {{ add("an awesome book");}});

// write epub
EpubWriter epubWriter = new EpubWriter();
epubWriter.write(book, new FileOutputStream("mynewbook.epub"));