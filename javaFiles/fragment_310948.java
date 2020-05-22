try (BufferedReader listReader = new BufferedReader(new FileReader("/data/list.txt"));
            BufferedReader csvReader = new BufferedReader(new FileReader("/data/csvread.txt"))) {
        String listItem = null;
        Set<String> listItems = new HashSet<>();
        while ((listItem = listReader.readLine()) != null) {
            listItems.add(listItem.toLowerCase().split("¬")[1]);
        }

        String csvItem;
        int count = 0;
        while ((csvItem = csvReader.readLine()) != null) {
            System.out.println("before second loop:" + csvItem);

            for (String item : listItems) {
                System.out.println("list Item: " + item);
                System.out.println("csv Item: " + csvItem.toLowerCase());
                if (item.contains(csvItem.toLowerCase())) {
                    count++;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}