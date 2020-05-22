@GetMapping(path = "/byUserIdAndTimePeriod/{userId}/{startDate}/{endDate}")
        public ResponseEntity<List<Position>> getPositionByUserAndTimePeriod(@PathVariable Long userId, 
                @PathVariable Date startDate, 
                @PathVariable @DateTimeFormat(pattern="yyy-MM-dd") Date endDate) {
            return new ResponseEntity<>(new ArrayList<Position>(positionService.getPositionByUserAndTimePeriod(userId,startDate,endDate)),HttpStatus.OK);
        }