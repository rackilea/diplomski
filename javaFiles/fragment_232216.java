ArrayList<String> ar = new ArrayList<>();

    Field f = ar.getClass().getDeclaredField("elementData");
    f.setAccessible(true);
    int l = ((Object[]) f.get(ar)).length;
    System.out.println(l); // 0

    ar.add("1");

    int x = ((Object[]) f.get(ar)).length;
    System.out.println(x); // 10