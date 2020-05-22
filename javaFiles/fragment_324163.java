// Create instruction label
JLabel instruction = new JLabel("["+ (id+5) + "]: Select an image of maximum dimensions 720 * 350 pixels."); 
// Style it
instruction.setForeground(Settings.SITE_GREEN);
instruction.setFont(Settings.SUBTITLEFONT);
// Add it.
add(instruction, gbc);