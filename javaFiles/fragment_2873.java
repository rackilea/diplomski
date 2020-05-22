while (itrtr.hasNext()) {
            Datum next = itrtr.next();
            // copy any values from the Datum to a fresh instance
            Datum insert = new Datum(next.location, next.value);
            if (!datums.containsKey(insert.location)) {
                datums.put(insert.location, insert);
            }
        }