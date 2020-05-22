{
    int yes = JOptionPane.YES_OPTION;
    List<Integer> list=new ArrayList<Integer>();

    do
    {
        String numberstring = JOptionPane.showInputDialog("Enter a "
                + "number: ");
        int number = Integer.parseInt(numberstring);

        list.add(number);

        yes = JOptionPane.showConfirmDialog(null, "Do you want to enter"
                + " another number?", "MinMax", JOptionPane.YES_OPTION);
    }
    while (yes == JOptionPane.YES_OPTION);

    int min = list.get(0), max = list.get(0);
    for (int i = 1; i < list.size(); i++) {
        if (min > list.get(i))
            min = list.get(i);
        if (max < list.get(i))
            max = list.get(i);
    }

    JOptionPane.showMessageDialog(null, "The min is " + min + " and the"
            + " max is " + max);
}