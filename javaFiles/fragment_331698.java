Map<Character,Double> map = new HashMap<Character,Double>();
map.put('a', 3.0);
map.put('b', 2.1);
// ... and so on

String msg = ... // get the message
Double width = 0.0;

for (Character c : msg.toCharArray())
    width += map.get(c);