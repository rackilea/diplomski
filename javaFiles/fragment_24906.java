public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {

        if (arg1 == null) {
            System.out.println("Just before finding element: " + arg0.toString() + " on browser: " + arg2.toString() );

        } else {
            System.out.println("Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
        }

    }