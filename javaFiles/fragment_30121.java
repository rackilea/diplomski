public String toString() {
        StringBuilder builder = new StringBuilder();
         Node p = first;
         while (p != null) { 
             builder.append("[").append(p.min).append(",").append(p.max).append("]");
             p = p.next;
         }
         return builder.toString();
    }