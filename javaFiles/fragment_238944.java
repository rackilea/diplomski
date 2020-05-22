int avgSal(List<Bank> banks) {
    int avg = 0;

    for(int i = 0; i < banks.size(); i++) {
        avg += banks.get(i).getSalery();
    }

    avg /= banks.size();

    return avg;
}