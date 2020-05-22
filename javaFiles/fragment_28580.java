JTextPane textPane_0 = new JTextPane();
JScrollPane jScrollPane1 = new JScrollPane(textPane_0);//warp text pane
//and set properties of wrapper
jScrollPane1.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jScrollPane1.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
ScrollPanes.add(jScrollPane1);


JTextPane textPane_1 = new JTextPane();
JScrollPane jScrollPane2 = new JScrollPane(textPane_1);
jScrollPane2.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jScrollPane2.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
ScrollPanes.add(jScrollPane2);