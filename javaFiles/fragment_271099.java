private void removeDuplicates(List<String> list) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j--);
                    count--;
                }
            }
        }
        count = list.size();

        if (count >= 3) {
            query1 = list.get(0);
            query2 = list.get(1);
            query3 = list.get(2);
        }
        else if (count >= 2) {
            query1 = list.get(0);
            query2 = list.get(1);
            query3 = "";
        }
        else if (count >= 1) {
            query1 = list.get(0);
            query2 = "";
            query3 = "";
        }
        else {
            query1 = "";
            query2 = "";
            query3 = "";
        }



        Log.d("One", query1);
        Log.d("Two", query2);
        Log.d("Three", query3);
    }