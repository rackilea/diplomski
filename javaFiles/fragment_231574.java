@RequestMapping("mypage.html")
public Resource myPage() {
    if(mycondition()) {
        return new ClassPathResource("path/to/mypage.html");
    } else {
        throw new ResourceNotFoundException();
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
private static class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {}
}