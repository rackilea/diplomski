//Finding above Average 
public static List<Integer> getAboveAverage(int[] times) {
    List<Integer> aboveAverages = new ArrayList<Integer>();

        for (int i = 0; i < times.length; i++) {

            if ((double)times[i] >= getAverageTime(times)) {

                aboveAverages.add(times[i]);

            }

        }

        return aboveAverages;
    }
}