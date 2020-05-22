@GetMapping(value = "renew")
 public ResponseEntity renew(@NonNull PageDto page,
                                @NonNull C2Criteria criteria) {
        Page<InsuranceRenew> renews = this.insuranceService.getRenew(page, criteria);
        return ResponseEntity.ok(renews);
 }