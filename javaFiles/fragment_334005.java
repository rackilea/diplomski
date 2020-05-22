@CrossOrigin
        @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public ResponseEntity<?> fetchDepartmentInfo() {
            try {
                List<Map<String, Object>> departmentList = departmentServices.fetchDepartments();

                if (departmentList == null || departmentList.isEmpty())
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                else
                    return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(departmentList), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }