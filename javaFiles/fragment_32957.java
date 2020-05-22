Scanner st = new Scanner("I'm 53.2 km away");
        while (!st.hasNextDouble())
        {
            st.next();
        }
        double value = st.nextDouble();
        System.out.println(value);