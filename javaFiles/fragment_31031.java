/**
 * doesn't touch the given lists, creates one new list with all the elements inside the given lists.
 * @param lists lists to add together
 * @param <T> A common class between lists
 */
public static <T> ArrayList<T> sumArrays (ArrayList<? extends T>... lists) {
    ArrayList<T> summed = new ArrayList<T>();
    for (ArrayList<? extends T> list: lists)
        summed.addAll(list);
    return summed;
}