int key = 0;

key |= a?(1):0;
key |= b?(1<<1):0;
key |= (c.size() > 1)?(1<<2):0;
...

String result = table[key]; // Or result = map.get(key);