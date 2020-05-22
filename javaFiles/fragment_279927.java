private JButton buttons[] = new JButton[5];

String names[] = {"Foo", "Bar", "Baz", "Fob", "Bao"};
for (int i = 0; i < buttons.length; ++i)
{
    JButton btn = new JButton(names[i]);
    btn.addActionListener(this);
    add(btn);
    buttons[i] = btn;
}