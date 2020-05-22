class Comparatorbuff implements Comparator<StringBuffer> {

        @Override
        public int compare(StringBuffer s1, StringBuffer s2) {
            return s1.toString().compareTo(s2.toString());

        }

}

in your main method: modify as follows
Set<StringBuffer> sb=new TreeSet<StringBuffer>(new Comparatorbuff());