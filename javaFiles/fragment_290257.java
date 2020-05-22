case AROHA_INCREASING: {
            if (swaraPool.indexOf(endStr) < swaraPool.indexOf(startStr)) {
                System.out.println("End string is before the start String");
                return (-1);
            }
            break; // without this, the thread will run the next case: block.
        }