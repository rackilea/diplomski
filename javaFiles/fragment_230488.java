JTextArea jTextArea = new JTextArea(20, 1);//To display pushed values
jTextArea.setEditable(false);

JButton btnPush = new JButton("Push");
function.add(btnPush);
btnPush.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String input = txtinput.getText();//first get the input
        if (!input.isEmpty()){//check that inout is not empty
            stack.push(Integer.parseInt(input));//push on stack
            System.out.println("input = " + input);
            jTextArea.setText("");//clear TextArea
            stack.forEach(element -> jTextArea.append(element + System.lineSeparator()));//for every element in stack add (element + \n)
        }else{
            System.out.println("Input is empty");
        }
    }
});