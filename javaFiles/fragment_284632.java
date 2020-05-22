$storeUid=myStore
$siteUid=mySite


# Cart Cleanup CronJobs (instance of CartRemovalCronJob)  
INSERT_UPDATE CartRemovalCronJob ; code[unique=true]      ; job(code)[default=cartRemovalJob] ; sites(uid)[default=$siteUid] ; sessionLanguage(isoCode)[default=en]
                                 ; $siteUid-CartRemovalJob

# Trigger for your job
INSERT_UPDATE Trigger ; cronJob(code)[unique=true]    ; second ; minute ; hour ; day ; month ; year ; relative ; active ; maxAcceptableDelay
                      ; $siteUid-CartRemovalJob       ; 0      ; 0      ; 5    ; -1  ; -1    ; -1   ; false    ; true   ; -1