try {
    huc = (HttpURLConnection)(new URL(url).openConnection());

    huc.setRequestMethod("HEAD");

    huc.connect();

    respCode = huc.getResponseCode();

    switch (respCode / 100) {
        case 2:
            if (respCode <= 226) {
                listTwo.add(new Response(respCode, url));
                System.out.println(respCode+": "+url+" is a success link");
                linkCountTwo++;
                System.out.println("Number of 200s : " + linkCountTwo);
                linkTextTwo.setText("Number of 200s : " + linkCountTwo);
            }
            break;
        case 3:
            if (respCode <= 308) {
                listThree.add(new Response(respCode, url));
                ...
            }
            break;
        case 4:
            listFour.add(new Response(respCode, url));
            ...
            break;
        case 5:
            listFive.add(new Response(respCode, url));
            ...
            break;
    }