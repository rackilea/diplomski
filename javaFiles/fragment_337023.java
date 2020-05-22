JPanel child = new JPanel( whatever layout manager you want );
child.add(...);
child.add(...);
JPanel wrapper = new JPanel();
wrapper.add( child );
frame.add(wrapper, BorderLayout.PAGE_START);