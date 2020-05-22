Object o = new HashMap<>();
Map<String, Object> map = (Map<String, Object>) o; // ok

Object o = new ArrayList<>();
Map<String, Object> map = (Map<String, Object>) o; //ClassCastException

Object o = new String();
Map<String, Object> map = (Map<String, Object>) o; //ClassCastException