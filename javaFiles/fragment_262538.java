short mask_full = (short) 0b1111111111;

    for (int i = 0; i < strings.size() - 1; i++) {
        String string_i = strings.get(i);
        short mask_i = masks[i];

        for (int j = i; j < strings.size(); j++) {
            String string_j = strings.get(j);
            short mask_j = masks[j];

            short mask_i_j_concatenated = (short) (mask_i | mask_j);
            if (mask_i_j_concatenated == mask_full) {
                System.out.println("Strings [" + string_i + "] and [" + string_j + "] form a pair.");
            }
        }
    }