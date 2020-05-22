while (emptyFile <= 1) {

            if (sc.hasNextLine()) {
                line = sc.nextLine();

                if ((!line.isEmpty())) {
                    doctor[i][x] = line;
                    System.out.println(doctor[i][x]);

                    x++;
                    emptyFile = 0;
                } else {
                    System.out.println("PRE call emptyFile: " + emptyFile);
                    emptyFile++;
                    System.out.println("Post call emptyFile: " + emptyFile);
                    if (emptyFile >= 2) {
                        sc.close();
                    } else {
                        i++;
                        x = 0;
                    }
                }
            }
        }