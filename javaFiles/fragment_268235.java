if (ll[i][j] == null) {
            ll = new LinkedList[i][j];
        } else if (ll[j][i] == null) {
            ll = new LinkedList[j][i];
        } else {
            ll[i][j].add(al.add(s));
        }