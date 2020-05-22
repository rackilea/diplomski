try
    {
        input = new Scanner(Paths.get("C:\\Users\\Home\\Desktop\\Student.txt"));
        while(input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            line.useDelimiter(",");
            int id = line.nextInt();
            String firstName = line.next();
            String lastName = line.next();
            String userName = line.next();
            String passWord = line.next();
            String type = line.next();
            enumUserType userType = enumUserType.valueOf(type.toUpperCase());
            String permission = line.next();
            enumPermissionType permissionType = enumPermissionType.valueOf(permission.toUpperCase());
            String course = line.next();
            String degree = line.next();

            Address userAddress = new Address(1, 23, "Fake street", "Suburb1", 2500, enumState.NSW);
            User user = new Student(id, firstName, lastName, userName, passWord, userType, permissionType, true, course, degree, userAddress);
            getLibrary().addUser(user);

        }
    }
    catch(IOException io)
    {
        System.out.println("Error opening file");
    }