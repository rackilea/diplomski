Comparator<DataItem> byName = new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                String searchKey = txtSearch.getText().toLowerCase();
                int item1Score = findScore(o1.getName().toLowerCase(), searchKey);
                int item2Score = findScore(o2.getName().toLowerCase(), searchKey);

                if (item1Score > item2Score) {
                    return -1;
                }

                if (item2Score > item1Score) {
                    return 1;
                }

                return 0;
            }

            private int findScore(String itemName, String searchKey) {
                int sum = 0;
                if (itemName.startsWith(searchKey)) {
                    sum += 2;
                }

                if (itemName.contains(searchKey)) {
                    sum += 1;
                }
                return sum;
            }
        };