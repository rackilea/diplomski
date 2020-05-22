Map<IntBuffer, Integer> map = new HashMap<>();
map.put(IntBuffer.wrap(new int[] {0, 0}), 0);
map.put(IntBuffer.wrap(new int[] {0, 1}), 1);
map.put(IntBuffer.wrap(new int[] {1, 0}), 2);
map.put(IntBuffer.wrap(new int[] {1, 1}), 3);

IntBuffer intBuffer = IntBuffer.wrap(new int[] {counterFlag, priorityEnable});
return map.get(intBuffer);