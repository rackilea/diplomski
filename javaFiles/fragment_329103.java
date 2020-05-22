try (Stream<String> stream = Files.lines(Paths.get(searchObject + ".txt"))) {

        List<String> abc = stream.filter(str->str.startsWith("001"))
                                 .map(s->s.split("001")[1]).collect(Collectors.toList());

        System.out.println(abc);    // A C Z

    } catch (IOException e) {
        e.printStackTrace();
    }