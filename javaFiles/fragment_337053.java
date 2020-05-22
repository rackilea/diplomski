Store {

    /* Your other fields */

    @NotNull
    private  MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file= file;
    }
}