while (true) {
        if (!isValid(passwordhere, errorList)) {
            System.out.println("The password entered here is invalid");
            for (String error : errorList) {
                System.out.println(error);
            }

            System.out.print("Please enter a given  password : ");
            passwordhere = in.nextLine();
        }
        else {
            System.out.println("Password is valid!");
            break;
        }
    }