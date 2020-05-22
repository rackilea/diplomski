List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
String line5 = replaceAge(lines.get(4), newAge);
lines.set(4, line5);
Path tmp = Files.createTempFile(prefix, suffix, attrs);
Files.write(path, lines)
Files.move(tmp, path, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);