List<String> optionList = new ArrayList<String>();
optionList.add("1");
optionList.add("2");

Object[] options = optionList.toArray();
int value = JOptionPane.showOptionDialog(
                null,
                "Please select your encryption Algorithm:(1 or 2)\n 1. Data Encryption       Standard(DES) \n 2. Advanced Encryption Standard(AES)",
                "Pick",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                optionList.get(0));

String opt = optionList.get(value);
System.out.println("You picked " + opt);