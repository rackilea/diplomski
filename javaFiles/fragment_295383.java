for (int i=0; i<78; i++) {
        if(sc.hasNextLine()) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<5; j++) {
                arr[i][j] = line[j];
            }
        } else {
            break;
        }
    }