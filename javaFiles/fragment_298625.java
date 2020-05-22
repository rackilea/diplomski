int[] keys = new int[]{KeyEvent.VK_A, KeyEvent.VK_B, ... }; // Your list of KeyEvent character constants here, adapt as desired. 

// Start optional for loop here if you want more than 1 random character
int randomValue = ThreadLocalRandom.current().nextInt(0, keys.length);

Robot.keyPress(keys[randomValue]);