for(int co=0;co<allControllers;co++)
        {
            gamepad = Controllers.getController(co);
            GamePadName=gamepad.getName();
            if(GamePadName.charAt(0)!='H' && GamePadName.charAt(0)!='U')
                Keys=checkGamepad(Keys);
        }