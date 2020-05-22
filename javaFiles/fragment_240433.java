case '3': 
    {
        System.out.println("Enter hard disk size in GB: ");
        hardDiskSize = keyboard.nextDouble();
        if(hardDiskSize<2) 
        {
            System.out.println("Hard disk size = Low");
        }

        else 
        {
            System.out.println("Hard disk size = Ok");
            s.setHardDisk(hardDiskSize); //setting the harddisk size in the "System" if it is ok
        }

        System.out.println();
        System.out.println("Enter memory size in MB: ");
        memorySize = keyboard.nextInt();
        if(memorySize<128) 
        {
            System.out.println("Memory Ok = False");
        }

        else 
        {
            s.setMemory(memorySize); //setting the new memory size within the "system" if it is ok
            System.out.println("Memory Ok = True");
        }
    }