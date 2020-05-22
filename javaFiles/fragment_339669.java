public static String findPhoneNumber(Scanner input, String name){
        String[] arr;
        String phoneNum = null;
        while (input.hasNextLine()){
            arr = input.nextLine().split(",");
            if (arr[0].endsWith(name)) {
                phoneNum = arr[2];
                break;
            }
        }
        return phoneNum;
    }