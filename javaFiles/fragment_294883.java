public static void main(String[] args)
{
    int[] arr = {1,34,323,456,5432,34566,33,45,654};
    int[] sort = {3, 2, 1, 4, 5 };

    int lastPos = 0;
    int loopPos = 0;
    int[] output = new int[arr.length];
    // process the whole array
    for (int s = 0; s < sort.length; ++s) {
        String fmt = String.format("^[0-9]{%d}$", sort[s]);
        Pattern pat = Pattern.compile(fmt);            

        // set to end of the current location
        loopPos = lastPos;
        for (int i = 0; i < arr.length; ++i) {
            int val = arr[i];
            Matcher m = pat.matcher(Integer.toString(val));
            if (m.matches()) {
                // start at the beginning of the loopPos
                // continue until lastPos
                if (lastPos == loopPos) {
                    output[lastPos++] = val;
                }
                else {
                    for (int ins = loopPos; ins < lastPos; ++ins) {
                        int atPos = output[ins];
                        // if we are smaller, must insert before
                        if (val <= atPos) {
                            for (int rev = lastPos; rev > loopPos; --rev) {
                                output[rev] = output[rev - 1];
                            }
                            output[ins] = val;
                            ++lastPos;
                            break;
                        }
                        else if (val > atPos) {
                            output[lastPos++] = val;
                            break;
                        }
                    }
                }

            }
        } //i
    } //s

    System.out.println(Arrays.toString(output));
}