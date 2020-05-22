String[] v = null;
        v = allAnimals().keySet().toArray(v);
        public int getSize() {
            return v.length;
        }
        public Object getElementAt(int index) {
            return v[index];
        }