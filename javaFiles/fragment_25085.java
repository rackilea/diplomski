for (int i = 0; i < list.size(); i++) {
        System.out.println(ss.indexOf(list.get(i))
                + " thru " + (ss.lastIndexOf(list.get(i)) + n - 1) + " : "
                + list.get(i));

    }