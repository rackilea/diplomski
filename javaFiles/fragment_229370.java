System.out.println("Enter the items you are buying, structured as 
                        followed" + " \nQuantity,Price,Item Name:");
    double tot = 0.0;
    for (int count = 1; count <= input; count++) {
        String line = keyboard.nextLine();
        outputStream.println(line);
        String[] arr = line.split(",");
        tot += (Integer.parseInt(arr[0]) * Double.parseDouble(arr[1]));
    }
    outputStream.println("Total sales: $" + tot);
    outputStream.close();
    System.out.println("Those values were written to " + fileName);