if(tnx.isPresent() && tnx.get().getId() != 0) {
        return ResponseEntity.ok(transactionService
                .get(Integer.valueOf(tnx.get().getId())).stream()
                .collect(Collectors.toList()));
    } 

    return ResponseEntity.notFound().build();