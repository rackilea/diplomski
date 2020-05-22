Single.just( intent )
            .filter( intent1 -> intent1 != null && intent1.getExtras() != null )
            .map( intent12 -> intent12.getExtras() )
            .flatMap( bundle -> 
              String imageData = bundle.getString( AdvImagePagerFragment.ARG_PANAROMIC_IMAGE_DATA);
              if (imageData != null) {
                return Observanle.just(imageData); 
              } else {
                return Observable.error(new RuntimeException("something is wrong));
              }
            ).subscribe(s -> mView.handleUrl( s ),
                        error -> mView.showError( error ));