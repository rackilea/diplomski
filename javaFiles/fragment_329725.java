689  private static class Partition<T> extends AbstractList<List<T>> {
690    final List<T> list;
691    final int size;
692
693    Partition(List<T> list, int size) {
694      this.list = list;
695      this.size = size;
696    }
697
698    @Override
699    public List<T> get(int index) {
700      checkElementIndex(index, size());
701      int start = index * size;
702      int end = Math.min(start + size, list.size());
703      return list.subList(start, end);
704    }
705
706    @Override
707    public int size() {
708      return IntMath.divide(list.size(), size, RoundingMode.CEILING);
709    }
710
711    @Override
712    public boolean isEmpty() {
713      return list.isEmpty();
714    }
715  }