System.out.println("\nDuplicate element(s)");
    for (int i = 0; i < list.size(); i++) {
        for (; (i+1) < list.size() && (list.get(i).equals(list.get(i+1)));) {
            System.out.print(list.get(i+1) + " ");
            list.remove(i+1);
        }
    }
    System.out.println();