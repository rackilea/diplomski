for (Iterator<Integer> it = range.iterator(); it.hasNext(); ) {
                Integer obj= it.next();
                if (obj == temp) {
                    // Remove the current element from the iterator and the list.
                    it.remove();
                    break;
                }
            }