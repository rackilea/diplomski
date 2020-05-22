if (!fileBudget.exists()) {   //creating new txt
    bud.setBudget(budget);
    fileBudget.createNewFile();
    System.out.println("TEXT File Created");
    FileWriter fw = new FileWriter(fileBudget, false);
    fw.write(bud.getBud() + "");
    fw.flush();
    fw.close();
    budget = salarySum - expenseSum;  //calculating budget
    JOptionPane.showMessageDialog(null, expDisplay + "\n\n" + salDisplay + "\n\n" + "You spent: "
            + expenseSum + "\n" + "Budget: " + budget);
}