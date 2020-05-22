@RequestMapping(value = "/contacts", method = RequestMethod.POST)
public ResponseEntity<Map<String, ContactInfo>> addContactInfo(@RequestBody Map<String, ContactInfo> contactInfoDto) throws JsonProcessingException {

    ContactInfo contactInfo = contactInfoDto.get("contact");
    if (contactInfo == null) {
        throw new IllegalArgumentException("Contact not found.");
    }

    contactInfo = this.contactInfoManager.addNew(contactInfo);
    Map<String, ContactInfo> map = new HashMap<>();
    map.put("contact", contactInfo);

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(map).length()));
    return new ResponseEntity<Map<String, ContactInfo>>(map, headers, HttpStatus.CREATED);
}