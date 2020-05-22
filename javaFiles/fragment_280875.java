@Override
        public K put(T key, K value) {
            // TODO Auto-generated method stub
            if (key == null) {
              throw new NullPointerException("Key must not be null.");
            }
            return super.put(key, value);
        }