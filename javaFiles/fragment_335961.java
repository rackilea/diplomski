public Income[] getIncome() {

    // Call database...

    List<Income> data = new ArrayList<Income>(25);

    while (rs.next()) {

        Income income = new Income();

        income.setID(rs.getInt(1)));
        income.setTips(rs.getInt(2)));
        income.setHours(rs.getInt(3)));
        income.setGas(rs.getInt(4)));
        income.setHourly(rs.getDouble(5)));
        income.setOther(rs.getDouble(6)));
        income.setOther2(rs.getDouble(7)));

        data.add(income);

    }

    return data.toArray(new Income[data.size()]);

}