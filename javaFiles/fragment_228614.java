private void read() {
    System.out.println(
     "Enter the amount of liquid in the bottle (0-100): "); 
     volume = keyboard.nextDouble(); 
     if (volume > MAX || volume < MIN) { read(); } }
}