605  private static <T> UnmodifiableIterator<List<T>> partitionImpl(
606      final Iterator<T> iterator, final int size, final boolean pad) {
607    checkNotNull(iterator);
608    checkArgument(size > 0);
609    return new UnmodifiableIterator<List<T>>() {
610      @Override
611      public boolean hasNext() {
612        return iterator.hasNext();
613      }
614      @Override
615      public List<T> next() {
616        if (!hasNext()) {
617          throw new NoSuchElementException();
618        }
619        Object[] array = new Object[size];
620        int count = 0;
621        for (; count < size && iterator.hasNext(); count++) {
622          array[count] = iterator.next();
623        }
624        for (int i = count; i < size; i++) {
625          array[i] = null; // for GWT
626        }
627
628        @SuppressWarnings("unchecked") // we only put Ts in it
629        List<T> list = Collections.unmodifiableList(
630            (List<T>) Arrays.asList(array));
631        return (pad || count == size) ? list : list.subList(0, count);
632      }
633    };
634  }