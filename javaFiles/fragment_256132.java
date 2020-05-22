private static class OptionComparator
    implements Comparator {

    /**
     * <p>Compares its two arguments for order. Returns a negative 
     * integer, zero, or a positive integer as the first argument 
     * is less than, equal to, or greater than the second.</p>
     *
     * @param o1 The first Option to be compared.
     * @param o2 The second Option to be compared.
     *
     * @return a negative integer, zero, or a positive integer as 
     * the first argument is less than, equal to, or greater than the 
     * second.
     */
    public int compare(Object o1, Object o2)
    {
        Option opt1 = (Option)o1;
        Option opt2 = (Option)o2;

        return opt1.getKey().compareToIgnoreCase(opt2.getKey());
    }
}