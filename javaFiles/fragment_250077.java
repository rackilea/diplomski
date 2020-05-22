class CustomObj {
    public String field;

    public CustomObj(){
        System.out.println("CustomObj constructor called");
    }

    @Override
    public String toString() {
        return "CustomObj{" +
                "field='" + field + '\'' +
                '}';
    }
}

....

  @RequestMapping("/pleasework")
    public String please(){
        System.out.println(userValues +  " and " + customObj);
        return "List values: "+ Arrays.toString(this.userValues.toArray())
                + " Obj value: " + this.customObj; //<---- use toString()
    }