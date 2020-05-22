@PostMapping
public ResponseEntity<User> post(UserCreateRequest request, @RequestPart("file") MultipartFile file) throws IOException {
    ftpService.uploadPhoto(file.getOriginalFilename(), file.getInputStream());

     return ResponseEntity.ok(userService.create(request));
 }