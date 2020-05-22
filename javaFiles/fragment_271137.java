String [] lookup = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

List<String> results = new ArrayList<String>();

void translatePhone(String phoneNumber, int position) {
    int index = Integer.parseInt(phoneNumber.substring(position, position + 1));
    for (int i = 0; i < lookup[index].length; i++) {
        String xlated = phoneNumber.substring(0, position) + lookup[index].charAt(i) + phoneNumber.substring(position + 1);
        if (position + 1 == phoneNumber.length) {
            results.add(xlated);
        } else {
            translatePhone(xlated, position + 1);
        }
    }
}