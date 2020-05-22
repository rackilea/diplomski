public ArrayList(Collection<? extends E> c) {
151         elementData = c.toArray();
152         size = elementData.length; 
153         // c.toArray might (incorrectly) not return Object[] (see 6260652)
154         if (elementData.getClass() != Object[].class)
155             elementData = Arrays.copyOf(elementData, size, Object[].class);
156     }