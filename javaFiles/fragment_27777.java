private static <R> List<R> compare(Path path1, Path path2, BiFunction<String, String, R> compare) throws IOException
{
    List<R> list = new ArrayList<>();
    try (Stream<String> s1 = Files.lines(path1);
         Stream<String> s2 = Files.lines(path2))
    {
        Iterator<String> itr1 = s1.iterator();
        Iterator<String> itr2 = s2.iterator();
        //compare only till both the files have some entry
        while (itr1.hasNext() && itr2.hasNext())
        {
            list.add(compare.apply(itr1.next(), itr2.next()));
        }
    }
    return list;
}