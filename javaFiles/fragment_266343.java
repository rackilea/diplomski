ArrayList<String> arrVal = mp.get(token_lhs);
if (arrVal == null) {
    arrVal = new ArrayList<String>();
    mp.put(token_lhs,arrVal);
}
arrVal.add(token_rhs);