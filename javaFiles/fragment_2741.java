switch (view.getId()) {

            case R.id.thumbL:
                view.setLayoutParams(layoutParams);
                joystick1.LeftY = (byte) (layoutParams.topMargin + 37);
                joystick1.LeftX = (byte) (layoutParams.leftMargin + 37);
                System.out.println("Left X Value: " + layoutParams.leftMargin + 37);
                System.out.println("Left Y Value: " + layoutParams.topMargin + 37);
                **break;**

            case R.id.thumbR:
                view.setLayoutParams(layoutParams);
                joystick1.RightX = (byte) (layoutParams.leftMargin + 37);
                System.out.println(" Right X Value: " + layoutParams.leftMargin +37);
                **break;**
         }