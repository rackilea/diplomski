private class myprofile extends AsyncTask<Void,Void,Boolean> {
    private String email;
    private String name;
    public myprofile(String email, String name){
        this.email = email;
        this.name = name;
    }
    ...
}