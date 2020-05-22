mapB.entrySet()
            .parallelStream()
            .filter(y -> y.getValue().equals(x.getValue()))
            .map(y -> y.getKey())
            .sorted()
            .forEach(val -> {

                synchronized (this) {
                    res.add(x.getKey());
                    res.add((Integer) val);
                }
            });