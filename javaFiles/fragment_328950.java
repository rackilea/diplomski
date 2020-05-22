if (AList.size() < 14) {
            Collections.sort(AList);
            return AList.get(k-1);
        }

        ArrayList<Integer> medians = new ArrayList<Integer>();


        for (int i = 0; i < AList.size() - AList.size() % 7; i = i + 7){
            medians.add(medianFind(AList.subList(i, i + 7)));
        }