public int compareTo(Object o) {
            Item i = (Item) o;
            if (this.getNumber() < i.getNumber())
                return -1;
            if (this.getNumber() > i.getNumber())
                return 1;
            return 0;
        }