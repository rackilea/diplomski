Collections.sort(markings, (o1, o2) -> {

            int value = o1.getName().compareToIgnoreCase(o2.getName());
            if(value == 0) {
                return o1.getOldName().compareToIgnoreCase(o2.getOldName());
            }

            if(o1.getName().equals("-")) {
                return 1;
            }
            if(o2.getName().equals("-")) {
                return -1;
            }

            return value;
        });