public static void print_player_info(String[][] data, String player) {
        String name = player.toLowerCase();
        for (int i = 0; i < data.length; i++) {
            String temp = Arrays.toString(data[i]);
            if(temp.toLowerCase().contains(player)){
                System.out.println(player + " - " + i);
            }

        }

    }