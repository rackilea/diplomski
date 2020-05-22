ArrayList<String> a2 = new ArrayList<>(a);
for (int i = 0; i < a2.size(); i++) {

    if (a2.equals(b)) {
        return true;
    }

    Collections.rotate(a2, 1);
}