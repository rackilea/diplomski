while ((s = file.readLine()) != null) {
        int[] vec = new int[2];
        vec[0] = Integer.parseInt(s.substring(0, 4).trim());
        vec[1] = Integer.parseInt(s.substring(5, 8).trim());
        vc.add(vec);
    }