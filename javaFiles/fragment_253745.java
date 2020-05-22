public static void quickSort(String[] event) {
    String temp;
    int a, b, c, d, e, f;

    // Sorting years
    for (int i = 0 ; i < event.length - 1 ; i++){
        a = Integer.valueOf(event[i].split("/")[2]);
        b = Integer.valueOf(event[i+1].split("/")[2]);
        // Sorting years
        if (a > b){
            temp = event[i];
            event[i] = event[i+1];
            event[i+1] = temp;
            quickSort(event);
        } else if (a == b){
            c = Integer.valueOf(event[i].split("/")[0]);
            d = Integer.valueOf(event[i+1].split("/")[0]);
            // Sorting months
            if (c > d){
                temp = event[i];
                event[i] = event[i+1];
                event[i+1] = temp;
                quickSort(event);
            } else if (c == d){
                e = Integer.valueOf(event[i].split("/")[1]);
                f = Integer.valueOf(event[i+1].split("/")[1]);
                // Sorting days
                if (e > f){
                    temp = event[i];
                    event[i] = event[i+1];
                    event[i+1] = temp;
                    quickSort(event);
                }
            }
        }
    }
}