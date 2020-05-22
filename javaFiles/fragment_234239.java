File file = new File(...);
            Resource resource = new FileSystemResource( file );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType( MediaType.IMAGE_JPEG );

            return new ResponseEntity<Resource>( resource, headers,
                    HttpStatus.OK );