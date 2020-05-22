String line = "c:\\MyMP3s\\4 Non Blondes\\Bigger!\\Faster, More!_Train.mp3";
System.out.println("Into the loop");

line = line.replaceAll(":\\\\", " ");
line = line.replaceAll("\\.", " ");
line = line.replaceAll("_", " ");
line = line.replaceAll("\\\\", " ");

line = line.replaceAll(" ", System.lineSeparator());

System.out.println(line);