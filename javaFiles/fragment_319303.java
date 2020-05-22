public boolean isExist(String strNama) {

    for (int i = 0; i < nama.size(); i++) {
        if (nama.get(i).equals(strNama)) {
            return true;
        }
    }

    return false;
}