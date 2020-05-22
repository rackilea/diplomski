boolean hasCaramel = false;
for (Candy candy : CandyDao.getAllCandys()) {
    if ("Caramel".equals(candy.getName())) {
        hasCaramel = true;
        break;
    }
}