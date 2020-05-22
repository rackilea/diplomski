int auxIndex = 0;
for (String line : buffer) {
        if (line.equals(route)) {
            mergeArray.add(line);           
            String prevElement = buffer.get(auxIndex - 1);
            if (prevElement.equals(direction)) {
                String addElem = buffer.get(auxIndex + 1);
                mergeArray.add(addElem);

            } else if (prevElement.equals(start)) {
                mergeArray.add("New direction");

            }

        }
        auxIndex++
}