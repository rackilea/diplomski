public class ReadFile{
    public static void main(String[]args) throws IOException{
        String expectedFileContent = "##########\n#A...#...#\n#.#.##.#.#\n#.#.##.#.#\n#.#....#B#\n#.#.##.#.#\n#....#...#\n##########";

        System.out.println(expectedFileContent);
        System.out.println(expectedFileContent.length());

        String x = readFile("file.txt", Charset.defaultCharset());
        System.out.println(x.length());
        if(expectedFileContent.equals(x.trim())){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
}
    static String readFile(String path, Charset encoding) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}