for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " | " + (entry.getValue().equals(maxValueInMap)));// Itrate through hashmap
            if (entry.getValue().equals(maxValueInMap)) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }