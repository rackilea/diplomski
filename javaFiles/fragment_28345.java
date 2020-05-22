Scanner input = new Scanner(new File("C:/Users/Charles/Desktop/GeometricObjectsData.txt"));

    // you read each line at a time, so better to have hasNextLine instead
    while(input.hasNextLine()) {
        String line = input.nextLine();
        System.out.println(line);
        String[] tokens = line.split(", ");
        if (tokens[0].equals("Circle"){
            Circle c = new Circle();
            float radius = Float.parseFloat(tokens[1]);
            c.setRadius(radius);

            // do what you wish with circle
        }
        else if (tokens[0].equals("Rectangle"){
            Rectangle r = new Rectangle();
            int height = Integer.parseInt(tokens[1]);
            int width = Integer.parseInt(tokens[2]);
            r.setSize(width,height);

            // do what you wish with rectangle
        }

    }