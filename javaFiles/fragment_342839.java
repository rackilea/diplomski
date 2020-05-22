ArrayList<ArrayList<String>> listofItems = new ArrayList<ArrayList<String>>();
            ArrayList<String> list1 = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();
            for (ArrayList<String> list : listofItems) {

                for (String s : list) {
                    // there shud be some condition how much elements you want in a
                    // list or some condition
                    // to decide in which list we need to add item
                    if (list.size() < 12)
                        list1.add(s);
                    else
                        list2.add(s);

                }

            }