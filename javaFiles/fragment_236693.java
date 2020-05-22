public class TwoSum {
    // create a hashmap to contain the NUMBER added and the COUNT of that number
    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public void add(int number) {
        // does the hashmap have the NUMBER as a key
        if (elements.containsKey(number)) {
            // get the COUNT of the NUMBER and increment it by 1
            // and update the hashmap
            elements.put(number, elements.get(number) + 1);
        } else {
            // the NUMBER doesn't exist in the hashmap,
            // so add it and set the COUNT to 1
            elements.put(number, 1);
        }
    }

    public boolean find(int value) {
        // Loop through the NUMBERS (which are keys in the hashmap
        for (Integer i : elements.keySet()) {
            // subtract the NUMBER (i) from the VALUE then
            // all we have to do is look for the TARGET in the hashmap
            int target = value - i;
            // start looking for the TARGET
            if (elements.containsKey(target)) {
                // If we made it here, we found a match
                // if I == TARGET, then there has to be a COUNT of at least 2
                // for example if VALUE = 6 and I = 3 then TARGET also = 3
                // so the COUNT of 3s in the hashmap has to be at least 2
                // if the COUNT is not >= 2 then we jump to the next I
                if (i == target && elements.get(target) < 2) {
                    continue; // jump to next I
                }
                return true; // we found a match to TARGET so we can exit
            }
        }
        return false; // no matches for TARGET 
    }
}