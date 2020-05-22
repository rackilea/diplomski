com.sun.glass.ui.Robot robot =
                com.sun.glass.ui.Application.GetApplication().createRobot();

        int y = robot.getMouseY();
        System.out.println("y point = " + y);
        int x = robot.getMouseX();
        System.out.println("x point= " + x);