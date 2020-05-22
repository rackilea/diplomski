for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]); // add this
            if (i + 1 < arr.length) {
                sb.append(",");
            }
        }