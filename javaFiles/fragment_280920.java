try (Stream<Path> stream = Files.find(Paths.get("Folder 1"), 5,
            (path, attr) -> path.getFileName().toString().equals("Myfile.txt") )) {
        System.out.println(stream.findAny().isPresent());
} catch (IOException e) {
        e.printStackTrace();
}