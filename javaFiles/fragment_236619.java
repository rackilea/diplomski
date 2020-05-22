public class CheckFocus extends JFrame {

    JList<String> focusedList = null;
    JList<String> list1 = new JList<>(new String[]{"A", "B"});
    JList<String> list2 = new JList<>(new String[]{"1", "2"});

    CheckFocus() {

        JButton btn = new JButton("Who has focus?");

        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {    

                if (focusedList.equals(list1))
                    System.out.println("list1");
                else if (focusedList.equals(list2))
                    System.out.println("list2");
                else
                    System.out.println("none");
            }
        });

        MyFocusListener mfl = new MyFocusListener();
        list1.addFocusListener(mfl);
        list2.addFocusListener(mfl);

        getContentPane().add(list1, BorderLayout.LINE_START);
        getContentPane().add(list2, BorderLayout.LINE_END);
        getContentPane().add(btn, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new CheckFocus();
    }


    class MyFocusListener extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {

            super.focusGained(e);
            focusedList = (JList<String>) e.getSource();
        }
    }
}