for (int i = 0; i < list.size(); i++)
    {
        String currentLine = list.get(i);
        String[] elements = currentLine.trim().split("\\s");
        int lastElement = Integer.parseInt(elements[elements.length - 1]);

        String desiredValue = elements[elements.length - 1 - lastElement];
        System.out.println("desiredValue = " + desiredValue);
    }