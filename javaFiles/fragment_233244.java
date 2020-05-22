String[] tab1 ={"AF","HB","ER"};
    String[] tab2 = Arrays.copyOf(tab1, tab1.length+5);
    tab2[3] = "HO";
    tab2[4] = "NF";
    tab2[5] = "BB";
    tab2[6] = "CD";
    tab2[7] = "PO";
    System.out.println(Arrays.toString(tab2));