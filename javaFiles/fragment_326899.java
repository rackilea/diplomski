T tmp1 = list.get(from1);
                                  T tmp2 = list.get(from2);
                                  list.set(from2, list.get(to2));
list.set(from1, list.get(to1));
                                  list.set(to2, tmp2);
list.set(to1, tmp1);