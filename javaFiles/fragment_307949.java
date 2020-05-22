try {
        throw new Exception();
    } catch (Exception ex) {
        String s = ex.getStackTrace()[1].getClassName();
        System.out.println(s);
    }