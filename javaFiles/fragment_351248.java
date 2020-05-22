final DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>(5000l);
FirebaseAuth.getInstance().verifyIdToken(firebaseAuthToken)
            .addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
                @Override
                public void onSuccess(FirebaseToken decodedToken) {
                    deferredResult.setResult(decodedToken);
                }
            });
return deferredResult;