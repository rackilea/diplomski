Static bool timeManager(){
   CurrentTime = getCurrentTime()
   TimeStamp = getTimeStamp()
   if(CurrentTime - TimeStamp > 1day-afewMinutes){
        UpdateTimeStamp(CurrentTime)
        return true
   }else{
        return false
   }
}
void jobWrapper(){
    if timeManager(){
        doTheJob()
    }else{
        log("Skipping job at "+currentTime+" because job ran "+lastTime)
    }
}