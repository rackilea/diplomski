public enum License { 

    GPL("GPL"),

    APACHE("Apache License");

    public License(String displayName) {
        this.displayName=displayName;
    }

    String displayName;

 }