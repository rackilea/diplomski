@RequestMapping ...
    public String handleRequest() {
        if(valid){
           return "forward:/path_to_my_another_controller";
        }else {
           return "forward:/somewhere_else";
        }
    }