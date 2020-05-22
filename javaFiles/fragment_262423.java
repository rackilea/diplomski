public static void merge(Integer[] gArray, int low, int mid1, int mid2, int mid3, int high,
                             Integer[] destArray)
    {
        int i = low, j = mid1, k = mid2, l = mid3, m = low;

        while (m < high) {
            if (i < mid1 && (j >= mid2 || gArray[i].compareTo(gArray[j]) <= 0)) {
                if (k >= mid3 || gArray[i].compareTo(gArray[k]) <= 0) {
                    if (l >= high || gArray[i].compareTo(gArray[l]) <= 0) {
                        destArray[m++] = gArray[i++];
                    } else {
                        destArray[m++] = gArray[l++];
                    }
                } else {
                    if (k < mid3 && (l >= high || gArray[k].compareTo(gArray[l]) <= 0)) {
                        destArray[m++] = gArray[k++];
                    } else {
                        destArray[m++] = gArray[l++];
                    }
                }
            } else {
                if (j < mid2 && (k >= mid3 || gArray[j].compareTo(gArray[k]) < 0)) {
                    if (l >= high || gArray[j].compareTo(gArray[l]) < 0) {
                        destArray[m++] = gArray[j++];
                    } else {
                        destArray[m++] = gArray[l++];
                    }
                } else {
                    if (k < mid3 && (l >= high || gArray[k].compareTo(gArray[l]) < 0)) {
                        destArray[m++] = gArray[k++];
                    } else {
                        destArray[m++] = gArray[l++];
                    }
                }
            }
        }
    }

    public static void mergeSort4WayRec(Integer[] gArray, int low, int high,
                                        Integer[] tempArray) {
        if (high - low < 2) {
            return;
        }

        int mid1 = low  + (high + 0 - low) / 4;
        int mid2 = mid1 + (high + 1 - low) / 4;
        int mid3 = mid2 + (high + 2 - low) / 4;

        mergeSort4WayRec(tempArray, low,  mid1, gArray);
        mergeSort4WayRec(tempArray, mid1, mid2, gArray);
        mergeSort4WayRec(tempArray, mid2, mid3, gArray);
        mergeSort4WayRec(tempArray, mid3, high, gArray);

        merge(tempArray, low, mid1, mid2, mid3, high, gArray);
    }

    public static void mergeSort4Way(Integer[] gArray) {

        if (gArray != null) {
            Integer[] tempArray = new Integer[gArray.length];

            for (int i = 0; i < gArray.length; i++) {
                tempArray[i] = gArray[i];
            }
            mergeSort4WayRec(gArray, 0, gArray.length, tempArray);
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[1024*1024];
        Random r = new Random();
        for(int i = 0; i < a.length; i++)
            a[i] = r.nextInt();
        long bgn, end;
        bgn = System.currentTimeMillis();
        mergeSort4Way(a);
        end = System.currentTimeMillis();
        for(int i = 1; i < a.length; i++){
            if(a[i-1] > a[i]){
                System.out.println("failed");
                break;
            }
        }
        System.out.println("milliseconds " + (end-bgn));
    }