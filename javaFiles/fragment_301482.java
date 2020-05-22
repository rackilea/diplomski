List<Foo> list = null;
    Collections.sort(list, new Comparator<Foo>() {

          public int compare(Foo o1, Foo o2) {
            return Integer.valueOf(o1.getOrder()).compareTo(Integer.valueOf( o2.getOrder()));
        }
    });