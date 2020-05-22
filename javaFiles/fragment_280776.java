for (Object object : AL) {
            ArrayList temp = (ArrayList) object;
            for (Object innerObject : temp) {
                if (innerObject instanceof String[]) {
                    printArray((String[]) innerObject);
                } else if (innerObject instanceof Integer[]) {
                    printArray((Integer[]) innerObject);
                } else if (innerObject instanceof Byte[]) {
                    printArray((Byte[]) innerObject);
                } else if (innerObject instanceof Boolean[]) {
                    printArray((Boolean[]) innerObject);
                } else if (innerObject instanceof Double[]) {
                    printArray((Double[]) innerObject);
                }
            }
        }

 private static void printArray(Object[] obj) {
        for (Object ob : obj) {
            System.out.print(ob + ",");
        }
        System.out.println();
    }