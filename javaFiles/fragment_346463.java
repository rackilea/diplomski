@Test
    public void testMixedNumbersArray() {
        Number[][] array = new Number[3][2];
        array[0][0] = 123; array[0][1] = 12.34;
        array[1][0] = 234; array[1][1] = 23.34;
        array[2][0] = 345; array[2][1] = 45.67;
        for (Number[] x : array) {
            System.out.println(Arrays.toString(x));
        }
    }

// outputs:
// [123, 12.34]
// [234, 23.34]
// [345, 45.67]