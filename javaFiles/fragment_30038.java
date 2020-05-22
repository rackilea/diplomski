public String recursionMethod() {
        String repeatRun = null;
        repeatRun = scanner.next();
        if (!("Y".equals(repeatRun) || "N".equals(repeatRun))) {
            System.out.println("Please enter the correct value. (Y/N)");
            return this.recursionMethod();
        }
        System.out.println("value of the entered variable->"+repeatRun);
        return repeatRun;
    }