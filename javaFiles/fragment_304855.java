public static void main(String[] args) {
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{0})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 1})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 0, 1})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 1, 1, 1, 1, 1, 1})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 1, 1, 1, 1, 1, 1, 0})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 1, 1, 1, 1, 1, 1, 1})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{0, 0, 1, 1, 0, 0, 0, 0})));
  System.out.println(Arrays.toString(bitsToBytes(new byte[]{1, 1, 1, 1, 1, 1, 1, 1,
                                                            0, 0, 1, 1, 0, 0, 0, 0})));
}