public List<E> getAll(List<E> list) {
     if (value != null) list.add(value);
     if (left != null) left.getAll(list);
     if (right != null) right.getAll(list);
     return list;
}