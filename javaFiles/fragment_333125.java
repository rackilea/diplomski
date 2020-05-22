public void random() {
    int rand = new java.util.Random().nextInt(10);
    convert(rand);
}

public void convert(int rand) {
    int vk = 0;
    switch (rand) {
    case 0:
        vk = java.awt.event.KeyEvent.VK_0;
        break;
    case 1:
        vk = java.awt.event.KeyEvent.VK_1;
        break;
    case 2:
        vk = java.awt.event.KeyEvent.VK_2;
        break;
    case 3:
        vk = java.awt.event.KeyEvent.VK_3;
        break;
    case 4:
        vk = java.awt.event.KeyEvent.VK_4;
        break;
    case 5:
        vk = java.awt.event.KeyEvent.VK_5;
        break;
    case 6:
        vk = java.awt.event.KeyEvent.VK_6;
        break;
    case 7:
        vk = java.awt.event.KeyEvent.VK_7;
        break;
    case 8:
        vk = java.awt.event.KeyEvent.VK_8;
        break;
    case 9:
        vk = java.awt.event.KeyEvent.VK_9;
        break;
    }
    System.out.println(rand+"->"+vk);
}