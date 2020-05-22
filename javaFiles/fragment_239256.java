Calendar cal = Calendar.getInstance();
            cal.setTime(newReturnDate);

            cal.set(Calendar.HOUR,11 );
            cal.set(Calendar.MINUTE,39 );   
            newReturnDate=cal.getTime();
            System.out.println(newReturnDate);