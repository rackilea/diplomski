for (int i= k; i < a.length; i++) {
                    if (a[i] < values[counter]) { // Found small value
                        // Insert sorted
                        for (int j = k-1; j >= 0; j--) {
                            if (j == 0 || a[i] > values[j-1]) { // Insert pos
                                // Move greater ones up.
                                for (int m = k - 1; m > j; m--) {
                                    values[m] = values[m - 1];
                                }
                                values[j] = a[i]; // Store
                                break; // Done
                            }
                        }
                    }
            }