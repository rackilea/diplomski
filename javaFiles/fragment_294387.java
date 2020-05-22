try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

        System.out.print("Enter text : ");
        String input = br.readLine();
        System.out.println(input);

    } catch (Exception e) {
        e.printStackTrace();
    }