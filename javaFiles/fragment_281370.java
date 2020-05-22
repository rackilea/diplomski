public List<E> getAll() {
     List<E> list = new ArrayList<>();
     if (value != null) list.add(value);
     if (left != null) list.addAll(left.getAll());
     if (right != null) list.addAll(right.getAll());
     return list;
}