for (int i = 0; i < number; i++){
    String elementInfo =
            JOptionPane.showInputDialog("Input value for element " + (i + 1));
        int element = Integer.parseInt(elementInfo);

    min_array[i] = element;
}

System.out.println('\u000C'); /*using BlueJ, this clears the console*/

for (int i = 0; i < number; i++){
    System.out.println(min_array[i]);
}