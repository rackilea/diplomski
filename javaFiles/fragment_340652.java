public Employee(String name, int totalSales, int salesPeriod, double experienceMultiplier) {
        try {
            this.setName(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.setTotalSales(totalSales);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.setSalesPeriod(salesPeriod);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.setExperienceMultiplier(experienceMultiplier);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }