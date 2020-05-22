String group_names[] = {"A-G", "H-N", "O-U", "V-Z"
    };

    String country_names[] = {"1","2"};

    int Images[] = {R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher
    };


    ArrayList<Group> list = new ArrayList<Group>();
    ArrayList<Child> ch_list;
    int size = 2;
    int j = 0;

    for (String group_name : group_names) {
        Group gru = new Group();
        gru.setName(group_name);
        ch_list = new ArrayList<Child>();
        for (j=0; j < size; j++) {
            Child ch = new Child();
            // Set the fields
            ch.setDetails("item:"+j);
            ch.setName(country_names[j]);
            ch.setImage(Images[j]);
            ch_list.add(ch);
        }
        gru.setItems(ch_list);
        list.add(gru);
        //size = size + 2;
    }
    return list;
}