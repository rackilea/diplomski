// find minimum first
int min = Integer.MIN_VALUE;
for(Entry<Request, Integer> entry : this.map.entrySet()) {
    min = Math.min(min, map.getValue())
}

// add all elements that have a value equal to min
List<Request> minKeyList = new ArrayList<Request>();
for(Entry<Request, Integer> entry : this.map.entrySet()) {
    if(min.getValue() == min) {
        minKeyList.add(entry.getKey());
    }
}