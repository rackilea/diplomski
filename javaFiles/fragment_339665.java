List<Double> doubleList = new ArrayList<Double>();            

while ((s = stdInput.readLine()) != null)  {
    System.out.println(s);
    if(s.contains("TTL")) {
        // Get value as a double
        Double val = Double.parseDouble(s.substring(44, 47));
        // Add to doubleList
        doubleList.add(val);
    }
}

// Call deviation
Deviation.deviation(doubleList)