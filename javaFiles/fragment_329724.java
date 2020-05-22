681  public static <T> List<List<T>> partition(List<T> list, int size) {
682    checkNotNull(list);
683    checkArgument(size > 0);
684    return (list instanceof RandomAccess)
685        ? new RandomAccessPartition<T>(list, size)
686        : new Partition<T>(list, size);
687  }