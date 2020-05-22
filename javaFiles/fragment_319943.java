if (arr1[0] != arr2[0]) {
        throw some exception;
    }

    if (arr1[0] == arr1[1]) { // we now know arr1[0] == arr2[0] == arr1[1]
        if (arr2[0] == arr2[1]) { // all equal
            assert arr1[1] == arr2[1];
            // condition 5
        } else {
            // condition 4
        }
    } else { // arr1[0] != arr1[1]
        if (arr2[0] == arr2[1]) { // arr1[0] == arr2[0] == arr2[1]
            // condition 3
        } else {
            if (arr1[1] == arr2[1]) {
                // condition 2
            } else {
                // condition 1
            }
        }
    }