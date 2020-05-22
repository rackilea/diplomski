public CardJPanel()
{
    panelCont.setLayout(cl);
    this.add(panelCont);
    panelFirst.add(buttonOne);
    panelSecond.add(buttonSecond);
    panelFirst.setBackground(Color.BLUE);
    panelSecond.setBackground(Color.GREEN);

    panelCont.add(panelFirst, "1");
    panelCont.add(panelSecond, "2");

    this.add(panelCont);
    cl.show(panelCont, "1");

    buttonOne.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            cl.show(panelCont, "2");
        }
    });

    buttonSecond.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            cl.show(panelCont, "1");
        }
    });

}