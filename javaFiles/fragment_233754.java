String str = ""; //work to read
String result = ""; //final resul
do {
    str = JOptionPane.showInputDialog("Enter a word");
    if (!str.equals("xxx")) {//if word != xxx then you can add it else escape it
        result += str + " ";
    }

} while (!str.equalsIgnoreCase("xxx"));

System.out.println(result);