int[] data = {1, 4, 6, 13, 14, 23, 30, 45, 58, 67, 76, 89, 99};
    int find =  67;
    int start = 0;
    int end= data.length - 1;
    int mid = 0;
    System.out.println("Find - "+find);
    while (start <= end) {
        mid = (start + end) / 2;
        if(find == data[mid]) {
            break;
        } else if(find > data[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }   
        System.out.println("Index - "+mid+" - val - "+data[mid]+" - not found");
    }

    if (data[mid] == find) {
        System.out.println("Index - "+start+" - val - "+find+", data found");
    } else {
        System.out.println("Data not found");
    }