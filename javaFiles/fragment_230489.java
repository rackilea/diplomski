JTextArea jTextArea = new JTextArea(20, 1);//To display pushed values
jTextArea.setEditable(false);

JButton btnPush = new JButton("Push");
JButton btnPop = new JButton("Pop");
JButton btnPeek = new JButton("Peek");
JButton btnUpdate = new JButton("Reload stack");

ActionListener updateListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        jTextArea.setText("");//clear TextArea
        stack.forEach(x -> jTextArea.append(x + System.lineSeparator()));//for every element in stack add (element + \n)
    }
};
btnUpdate.addActionListener(updateListener);
btnPush.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String input = txtinput.getText();
        if (!input.isEmpty()) {
            stack.push(Integer.parseInt(input));
            System.out.println("input = " + input);                    
            updateListener.actionPerformed(new ActionEvent(btnPush, 0, ""));//call the updateListener to refresh jTextArea
        } else {
            System.out.println("Input is empty");
        }

    }
});
function.add(btnPush);
function.add(btnPop);
function.add(btnPeek);

function.add(jTextArea);
function.add(btnUpdate);