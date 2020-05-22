URL website = new URL("http://mk7vrlist.altervista.org/databases/test.txt");

WritableByteChannel rbc = Channels.newChannel(website.openConnection().getOutputStream());

FileOutputStream fos;
fos = new FileOutputStream("C:/recfile.txt");

fos.getChannel().transferTo(0, Long.MAX_VALUE, rbc);

fos.close();