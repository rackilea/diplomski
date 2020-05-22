enum Status{
    Option1("x"),
    Option2("y", "z"),
    Option3("c"),
    Default;

    Status (String ... values){
        this.values = values;
    }

    String [] values;

    static Status convert(Set<String> set){
        for (Status status : Status.values())
            for (String str : status.values)
                if (set.contains(str))
                    return status;
        return Default;
    }
}