JPanel panel = new JPanel( new GridLayout(...) );

// add components to panel

for (...)
}
    for (...)
    {
        JTextField textField = new JTextField(10);
        panel.add( textField );
    }
}

JScrollPane scrollPane = new JScrollPane( panel );
frame.add(scrollPane);