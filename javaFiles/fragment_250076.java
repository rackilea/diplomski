@RequestMapping("/pleasework")
    public String please(){
        System.out.println(userValues +  " and " + customObj);
        return "List values: "+ Arrays.toString(this.userValues.toArray())
                + " Obj value: " + this.customObj.getField();// <--- use getter
    }