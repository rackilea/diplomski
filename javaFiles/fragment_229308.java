private Set<Widget> treeSet;
....
treeSet = new TreeSet<Widget>(new Comparator<Widget>() {
            public int compare(Widget w1, Widget w2)
            {
                if(w1.getId() < w2.getId()) return -1;
                else if(w1.getId() > w2.getId()) return 1;
                return w1.getName().compareTo(w2.getName());
            }
           });