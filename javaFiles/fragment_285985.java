if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
        {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            zpos -= 0.1f;
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }