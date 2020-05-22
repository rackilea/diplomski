try
    {
        input = new Scanner(Paths.get("C:\\Users\\Home\\Desktop\\Student.txt"));
        while(input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            int id = Integer.parseInt(line[0]);
            String firstName = line[1];
            String lastName = line[2];
            String userName = line[3];
            String passWord = line[4];
            String type = line[5];
            enumUserType userType = enumUserType.valueOf(type.toUpperCase());
            String permission = line[6];
            enumPermissionType permissionType = enumPermissionType.valueOf(permission.toUpperCase());
            String course = line[7];
            String degree = line[8];

            Address userAddress = new Address(1, 23, "Fake street", "Suburb1", 2500, enumState.NSW);
            User user = new Student(id, firstName, lastName, userName, passWord, userType, permissionType, true, course, degree, userAddress);
            getLibrary().addUser(user);

        }
    }
    catch(IOException io)
    {
        System.out.println("Error opening file");
    }