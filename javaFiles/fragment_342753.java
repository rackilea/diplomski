@Override
    public int compare(YourClass lhs, YourClass rhs) {

            YourClass p1 = (YourClass) lhs;
            YourClass p2 = (YourClass) rhs;

            int first = p1.ClientName; //use your getter if you want
            int second = p2.ClientName;

                if (second < first) {
                    return 1;
                }

                else if (second > first) {
                    return -1;
                }

                else {
                    return 0;
                }
        }