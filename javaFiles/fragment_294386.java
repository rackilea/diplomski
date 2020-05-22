try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text : ");
        String input = br.readLine();
        System.out.println(input);
        br.close();

    } catch (Exception e) {
        e.printStackTrace();
    }