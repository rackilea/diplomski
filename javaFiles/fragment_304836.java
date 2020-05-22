int highestCount = -1;
String mostEnteredProductType = null;
for (Entry<String,Integer> entry : map.entrySet()) {
    if (entry.getValue() > highestCount) {
        highestCount = entry.getValue();
        mostEnteredProductType = entry.getKey();
    }
}

System.out.println(mostEnteredProductType + " was the most ordered product.");