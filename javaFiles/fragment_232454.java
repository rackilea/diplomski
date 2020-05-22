if (italic.isSelected() )//1st condition
    f = new Font("Serif", Font.ITALIC, 30);
else if (bold.isSelected() )
    f = new Font("Serif", Font.BOLD, 30);
else if ( bold.isSelected() && italic.isSelected() )
    f = new Font("Serif", Font.BOLD | Font.ITALIC, 30);
else 
    f = new Font("Serif", Font.PLAIN, 30);